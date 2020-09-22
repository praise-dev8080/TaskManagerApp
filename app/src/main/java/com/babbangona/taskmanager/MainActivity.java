package com.babbangona.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declare activity ui elements
    private EditText username;
    private ImageButton login;

    //declare shared preferences variables
    public static final String MYPREFERENCES = "loginPref";
    public static final String loginUsername = "nameKey";
    SharedPreferences sharedpreference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.editLogin);
        login = findViewById(R.id.btnLogin);

        //create user preferences
        sharedpreference = getSharedPreferences(MYPREFERENCES, Context.MODE_PRIVATE);
        //get user name if exists
        username.setText(sharedpreference.getString(loginUsername, " "));
    }

    //method for creating preferences
    public void createPreferences(String username){
        SharedPreferences.Editor editor = sharedpreference.edit();
        editor.putString(loginUsername,username);
        editor.apply();
    }

    //method for next activity
    public void nextActivity(Class activity, String data){
        Intent intent = new Intent(getApplicationContext(), activity);
        intent.putExtra("username", data);
        startActivity(intent);
    }

    public void btnLogin(View view){
        //check if username is empty string
        String name = username.getText().toString().trim();
        if(name.equals("")){
            Toast.makeText(this, "Username can't be empty", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            createPreferences(name);
            Toast.makeText(this, "login successful", Toast.LENGTH_SHORT).show();
            nextActivity(tasksview.class, name);
        }

    }
}