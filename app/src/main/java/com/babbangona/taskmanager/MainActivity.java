package com.babbangona.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private ImageButton login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.editLogin);
        login = findViewById(R.id.btnLogin);
    }

    public void btnLogin(View view){
        //check if username is empty string
        String name = username.getText().toString().trim();
        if(name.equals("")){
            Toast.makeText(this, "Username can't be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        else {

        }

    }
}