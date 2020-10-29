package com.example.user.studentfacultyapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.studentfacultyapplication.R;

public class Routine2Activity extends AppCompatActivity {

    private static ListView list_view;
    private static String[] DAYS = new String[]{"A_day", "B_day", "C_day", "D_day", "E_day"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine2);
        list_view=(ListView) findViewById(R.id.listView);
        listView();
    }
    public void listView(){
        list_view=(ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,R.layout.days,DAYS);
        list_view.setAdapter(adapter);
        list_view.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        String value=(String) list_view.getItemAtPosition(position);
                        Toast.makeText(Routine2Activity.this,"Position :"+ position + "value :"+ value,Toast.LENGTH_LONG).show();

                        if (position == 0) {
                            Intent myintent = new Intent(view.getContext(), Aday2Activity.class);
                            startActivityForResult(myintent, 0);
                        }
                        if (position == 1) {
                            Intent myintent = new Intent(view.getContext(), Bday2Activity.class);
                            startActivityForResult(myintent, 1);
                        }
                        if (position == 2) {
                            Intent myintent = new Intent(view.getContext(), Cday2Activity.class);
                            startActivityForResult(myintent, 2);
                        }
                        if (position == 3) {
                            Intent myintent = new Intent(view.getContext(), Dday2Activity.class);
                            startActivityForResult(myintent, 3);
                        }
                        if (position == 4) {
                            Intent myintent = new Intent(view.getContext(), Eday2Activity.class);
                            startActivityForResult(myintent, 4);
                        }
                    }
                });
    }
}
