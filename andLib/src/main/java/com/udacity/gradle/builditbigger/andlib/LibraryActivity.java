package com.udacity.gradle.builditbigger.andlib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class LibraryActivity extends AppCompatActivity {
    private static final String ARG_JOKE = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_activity);

        TextView tv = findViewById(R.id.tv_joke);
        Intent intent = getIntent();
        tv.setText(intent.getStringExtra(ARG_JOKE));
    }
}
