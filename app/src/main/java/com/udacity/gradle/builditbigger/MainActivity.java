package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.andlib.LibraryActivity;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.javalib.Joker;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public static final String ARG_JOKE = "";
    private Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
// The button call LibraryActivity and pass the joke from the Java Library to the Android Library.
    public void launchLibraryActivity(View view) {
        Intent intent = new Intent(this, LibraryActivity.class);
        intent.putExtra(ARG_JOKE, new Joker().getJoke());
        startActivity(intent);

        // Toast.makeText(this, new Joker().getJoke(), Toast.LENGTH_SHORT).show();
    }
// The button call postJoke from GCE by GceAsyncTask.
    public void postJoke(View view) {
       new EndpointsAsyncTask().execute(this);

    }

    public static class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
        private static MyApi myApi = null;
        private Context context;

        @Override
        protected String doInBackground(Context... params) {
            if (myApi == null) {
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        // options for running against local devappserver
                        // - 127.0.0.1 is localhost's IP address in Android emulator
                        // - turn off compression when running against local devappserver
                        .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });
                // end options for devappserver

                myApi = builder.build();
            }
            context = params[0];

            try {

                return myApi.tellJoke().execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
//            intent.putExtra(ARG_JOKE, new Joker().getJoke());

            Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        }
    }
}
