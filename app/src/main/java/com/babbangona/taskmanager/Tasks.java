package com.babbangona.taskmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tasks {
    private String status;
    private String task;



    private static ArrayList<String> todo = new ArrayList<>();
    private static ArrayList<String> doing = new ArrayList<>();
    private static ArrayList<String> done = new ArrayList<>();

    public Tasks(String status, String task){
        if (status.equals("todo")){
            todo.add(task);
        }
        else if (status.equals("doing")){
            doing.add(task);
        }
        else {
            done.add(task);
        }
    }

    public  String getStatus() {
        return status;
    }

    public void setStatus() {
        this.status = status;
    }

    public static ArrayList<String> getTask(String status) {
        if(status.equals("todo")){
            return todo;
        }
        else if (status.equals("doing")){
            return doing;
        }
        else {
            return done;
        }
    }

    public void setTask(String task) {
        this.task = task;
    }
}
