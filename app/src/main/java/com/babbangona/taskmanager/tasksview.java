package com.babbangona.taskmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class tasksview extends AppCompatActivity {

    private TextView username;
    private MaterialButton logout;
    private FloatingActionButton fab;
    private RecyclerView tasksRecyclerView;
    private Button btnTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskview);

        //initialize view elements
        username = findViewById(R.id.txtUsername);
        logout = findViewById(R.id.btnLogout);
        fab = findViewById(R.id.fab_task);
        btnTodo = findViewById(R.id.btnTodo);

        todoListener(btnTodo);


        //receive intent
        Intent intent = getIntent();
        String displayName = intent.getStringExtra("username");
        String upperString = displayName.substring(0, 1).toUpperCase() + displayName.substring(1).toLowerCase();

        //use data received
        username.setText(upperString + "'s" + " Tasks");

        //initialize class;
        new Tasks("todo", "eat rice");
        new Tasks("todo", "wash clothes");
        new Tasks("doing", "eating beans");
        new Tasks("doing", "coding");
        new Tasks("done", "fixing bugs");
        new Tasks("done", "creating Facebook");


    }


    public void logout(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("true", "true");
        startActivity(intent);
    }


    public void createTask(View view){
        Intent intent = new Intent(getApplicationContext(), AddTask.class);
        startActivity(intent);
    }

    //recyclerAdapter
    public void RecAdapter(String status){
        tasksRecyclerView = findViewById(R.id.taskRecycler);


        ArrayList<String> tasks = Tasks.getTask(status);
        TasksRecViewAdapter adapter = new TasksRecViewAdapter();
        adapter.setTasks(tasks);

        tasksRecyclerView.setAdapter(adapter);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    //To do Listener
    public void todoListener(View view){
        Button b = (Button)view;
        Toast.makeText(this, b.getText().toString(), Toast.LENGTH_SHORT).show();
//        System.out.println(b.getText().toString());
        RecAdapter(b.getText().toString());

    };

    //Doing Listener
    public void doingListener(View view){
        Button b = (Button)view;
        Toast.makeText(this, b.getText().toString(), Toast.LENGTH_SHORT).show();
        RecAdapter(b.getText().toString());
    }

    //Done Listener
    public void doneListener(View view){
        Button b = (Button)view;
        Toast.makeText(this, b.getText().toString(), Toast.LENGTH_SHORT).show();
        RecAdapter(b.getText().toString());


    //create popupdialogue



    }













}