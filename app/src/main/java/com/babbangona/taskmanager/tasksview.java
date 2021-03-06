package com.babbangona.taskmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class tasksview extends AppCompatActivity implements TasksRecViewAdapter.OnTaskListener {

    private TextView username;
    private MaterialButton logout;
    private FloatingActionButton fab;
    private RecyclerView tasksRecyclerView;
    private Button btnTodo;
    Dialog statusDialog;
    ArrayList<String> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskview);

        //initialize view elements
        username = findViewById(R.id.txtUsername);
        logout = findViewById(R.id.btnLogout);
        fab = findViewById(R.id.fab_task);
        btnTodo = findViewById(R.id.btnTodo);
        String upperString, displayName;
        statusDialog = new Dialog(this);

        todoListener(btnTodo);


        //receive intent
        Intent intent = getIntent();
        if(intent.getStringExtra("username") != null || intent.getStringExtra("username") == null)
            {
            SharedPreferences sharedpreference = getSharedPreferences(MainActivity.MYPREFERENCES, Context.MODE_PRIVATE);
            displayName = sharedpreference.getString(MainActivity.loginUsername, "");
            upperString = displayName.substring(0, 1).toUpperCase() + displayName.substring(1).toLowerCase();
            username.setText(upperString + "'s" + " Tasks");
        }

    }


    /*
    Method for logging out of the app and resetting the shared preferences to be empty
    * */
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


        tasks = Tasks.getTask(status);
        TasksRecViewAdapter adapter = new TasksRecViewAdapter(this);
        adapter.setTasks(tasks);

        tasksRecyclerView.setAdapter(adapter);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    //To do Listener
    public void todoListener(View view){
        Button b = (Button)view;
        buttonColorChange(b);
        RecAdapter(b.getText().toString());

    };

    //Doing Listener
    public void doingListener(View view){
        Button b = (Button)view;
        buttonColorChange(b);
        RecAdapter(b.getText().toString());
    }

    //Done Listener
    public void doneListener(View view) {
        Button b = (Button) view;
        buttonColorChange(b);
        RecAdapter(b.getText().toString());
    }


    //create popupdialogue
    public void showPopup(){
        TextView txtTask = findViewById(R.id.recLayout);
        statusDialog.setContentView(R.layout.popuptasks);
        statusDialog.show();
        }


    /*
    * Overriding the onTaskClick method in the implemented interface from the recycler
    * view adapter.
    * */
    @Override
    public void onTaskClick(int position) {
        String pos = tasks.get(position);
        showPopup();
    }

    //status change buttons for pop up dialog

    public void changeTodo(View v){

    }

    public void changeDoing(View v){

    }

    public void changeDone(View v){

    }

    //close dialogue
    public void closeDialog(View v){
        statusDialog.dismiss();
    }

    /*
    * Change button color if active
    * */
    public void buttonColorChange(Button v){
        //get all buttons in the view and add
        Button todo = findViewById(R.id.btnTodo);
        Button doing = findViewById(R.id.btnDoing);
        Button done = findViewById(R.id.btnDone);
        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add(todo);
        buttons.add(doing);
        buttons.add(done);

        //loop over the array to change style of clicked and unclicked buttons
        for (Button b: buttons ){
            if (v != b){
                b.setBackgroundColor(getResources().getColor(R.color.white));
                b.setTextColor(getResources().getColor(R.color.colorRed));
            }
            v.setBackgroundColor(getResources().getColor(R.color.colorRed));
            v.setTextColor(getResources().getColor(R.color.white));
        }
        return;
    }


}