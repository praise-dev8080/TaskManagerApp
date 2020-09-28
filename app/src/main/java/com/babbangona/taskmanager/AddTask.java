package com.babbangona.taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddTask extends AppCompatActivity {

    private Spinner spinner;
    private TextView newTask;
    ArrayAdapter<String> adapter;
    ArrayList<String> options = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        newTask = findViewById(R.id.txtNewTask);

        options.add("todo");
        options.add("doing");
        options.add("done");

        spinner = findViewById(R.id.statusSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                options
        );

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
    }


    public void btnCreate(View view){
        try{
            Toast.makeText(this, spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            new Tasks(spinner.getSelectedItem().toString(), newTask.getText().toString());
            Toast.makeText(this, "Task added successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), tasksview.class);
            startActivity(intent);
        }
        catch (Exception e){
            Toast.makeText(this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }
    }

}