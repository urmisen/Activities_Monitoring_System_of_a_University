package com.example.user.studentfacultyapplication.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.studentfacultyapplication.R;
import com.example.user.studentfacultyapplication.sql.DatabaseHelper2;

public class AdmineActivity extends AppCompatActivity {
    DatabaseHelper2 mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admine);
        mydb= new DatabaseHelper2(this);
    }
}
