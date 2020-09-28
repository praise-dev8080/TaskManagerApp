package com.babbangona.taskmanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TasksRecViewAdapter extends RecyclerView.Adapter<TasksRecViewAdapter.ViewHolder> {

    private ArrayList<String> tasks = new ArrayList<>();
    private OnTaskListener mOnTaskListener;


    public  TasksRecViewAdapter(OnTaskListener onTaskListener){
        this.tasks = tasks;
        this.mOnTaskListener = onTaskListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drop_down, parent,false);
        ViewHolder holder = new ViewHolder(view, mOnTaskListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txtTask.setText(tasks.get(position));

    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public void setTasks(ArrayList<String> tasks) {
        this.tasks = tasks;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtTask;
        OnTaskListener onTaskListener;
        public ViewHolder(@NonNull View itemView, OnTaskListener onTaskListener) {
            super(itemView);
            txtTask = itemView.findViewById(R.id.recLayout);
            this.onTaskListener = onTaskListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onTaskListener.onTaskClick(getAdapterPosition());
        }
    }

    public interface OnTaskListener{
        void onTaskClick(int position);
    }

}
