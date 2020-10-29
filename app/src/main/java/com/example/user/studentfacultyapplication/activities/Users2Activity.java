package com.example.user.studentfacultyapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.studentfacultyapplication.R;

public class Users2Activity extends AppCompatActivity {

    private TextView textViewName;
    Button CT_Marks;
    Button Routine;
    Button Result;
    Button Notice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users2);

        textViewName = (TextView) findViewById(R.id.text1);
        CT_Marks = (Button) findViewById(R.id.button4);
        Routine = (Button) findViewById(R.id.button5);
        Result = (Button) findViewById(R.id.button6);
        Notice = (Button) findViewById(R.id.button7);
        String nameFromIntent = getIntent().getStringExtra("EMAIL");
        textViewName.setText("Welcome " + nameFromIntent);

        CT_Marks.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Clicked on Button", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Users2Activity.this, Marks2Activity.class);
                startActivity(i);
            }
        });

        Routine.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Clicked on Button", Toast.LENGTH_SHORT).show();
                Intent j = new Intent(Users2Activity.this, Routine2Activity.class);
                startActivity(j);
            }
        });

        Result.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Clicked on Button", Toast.LENGTH_SHORT).show();
                Intent k = new Intent(Users2Activity.this, Result2Activity.class);
                startActivity(k);
            }
        });

        Notice.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Clicked on Button", Toast.LENGTH_SHORT).show();
                Intent l = new Intent(Users2Activity.this, Notice2Activity.class);
                startActivity(l);
            }
        });

    }
}
