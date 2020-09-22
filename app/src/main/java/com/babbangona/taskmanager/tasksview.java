package com.babbangona.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class tasksview extends AppCompatActivity {

    private TextView username;
    private MaterialButton logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskview);

        //initialize view elements
        username = findViewById(R.id.txtUsername);
        logout = findViewById(R.id.btnLogout);

        //receive intent
        Intent intent = getIntent();
        String displayName = intent.getStringExtra("username");
        String upperString = displayName.substring(0, 1).toUpperCase() + displayName.substring(1).toLowerCase();

        //use data received
        username.setText(upperString + "'s" + " Tasks");

    }


    public void logout(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("true", "true");
        startActivity(intent);
    }

}