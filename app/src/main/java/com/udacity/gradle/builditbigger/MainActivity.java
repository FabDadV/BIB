package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.udacity.gradle.builditbigger.andlib.LibraryActivity;
import com.udacity.gradle.builditbigger.javalib.Joker;

public class MainActivity extends AppCompatActivity {
    public static final String ARG_JOKE = "";

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
}
