package com.babbangona.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class tasksview extends AppCompatActivity {

    private TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskview);

        //initialize view elements
        username = findViewById(R.id.txtUsername);

        //receive intent
        Intent intent = getIntent();
        String displayName = intent.getStringExtra("username");

        //use data received
        username.setText(displayName);

    }

}