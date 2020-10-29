package com.example.user.studentfacultyapplication.activities;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.studentfacultyapplication.R;
import com.example.user.studentfacultyapplication.sql.DatabaseHelper2;
import com.example.user.studentfacultyapplication.sql.DatabaseHelperNotice;

public class Notice2Activity extends AppCompatActivity {

    DatabaseHelperNotice myDb;
    Button btnviewAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice2);
        myDb = new DatabaseHelperNotice(this);
        btnviewAll = (Button)findViewById(R.id.button_viewAll);
        viewAll();
    }
    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Date :"+ res.getString(1)+"\n");
                            buffer.append("Subject :"+ res.getString(2)+"\n");
                            buffer.append("Message :"+ res.getString(3)+"\n\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }
}
