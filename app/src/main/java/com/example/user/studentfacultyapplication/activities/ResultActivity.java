package com.example.user.studentfacultyapplication.activities;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.studentfacultyapplication.R;
import com.example.user.studentfacultyapplication.sql.DatabaseHelperResult;

public class ResultActivity extends AppCompatActivity {

    DatabaseHelperResult myDb;
    EditText editname, editgpa, editcgpa, editTextID, editbacklog;
    Button btnAddData;
    Button btnviewAll;
    Button btnviewUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        myDb = new DatabaseHelperResult(this);

        editname = (EditText) findViewById(R.id.editText_1);
        editgpa = (EditText) findViewById(R.id.editText_2);
        editcgpa = (EditText) findViewById(R.id.editText_3);
        editbacklog = (EditText) findViewById(R.id.editText_4);
        editTextID = (EditText) findViewById(R.id.editText_5);
        btnAddData = (Button) findViewById(R.id.button_add);
        btnviewAll = (Button) findViewById(R.id.button_viewAll);
        btnviewUpdate = (Button) findViewById(R.id.button_update);

        AddData();
        viewAll();
        UpdateData();
    }

    public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editTextID.getText().toString(),
                                editname.getText().toString(), editgpa.getText().toString(),
                                editcgpa.getText().toString(), editbacklog.getText().toString());
                        if (isUpdate == true)
                            Toast.makeText(ResultActivity.this, "Data Update", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(ResultActivity.this, "Data not Updated", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void AddData(){
    btnAddData.setOnClickListener(
            new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            boolean isInserted = myDb.insertData(editname.getText().toString(), editgpa.getText().toString(),
                    editcgpa.getText().toString(), editbacklog.getText().toString());
            if (isInserted == true)
                Toast.makeText(ResultActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(ResultActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
        }
    }
        );
}

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if (res.getCount() == 0) {
                            // show message
                            showMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("ID :" + res.getString(0) + "\n");
                            buffer.append("Name :" + res.getString(1) + "\n");
                            buffer.append("GPA :" + res.getString(2) + "\n");
                            buffer.append("CGPA :" + res.getString(3) + "\n");
                            buffer.append("Backlog :" + res.getString(4) + "\n");
                        }

                        // Show all data
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
