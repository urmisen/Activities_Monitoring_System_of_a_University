package com.example.user.studentfacultyapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.studentfacultyapplication.R;

public class MainActivity extends AppCompatActivity {
    Button ob2, ob3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ob2=(Button) findViewById(R.id.button2);
        ob3=(Button) findViewById(R.id.button3);

        ob2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Clicked on Button", Toast.LENGTH_SHORT).show();
                Intent j=new Intent(MainActivity.this,StudentActivity.class);
                startActivity(j);
            }
        });

        ob3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Clicked on Button", Toast.LENGTH_SHORT).show();
                Intent k=new Intent(MainActivity.this,FacultyActivity.class);
                startActivity(k);
            }
        });
    }
}

