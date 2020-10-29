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
import com.example.user.studentfacultyapplication.sql.DatabaseHelper2;
import com.example.user.studentfacultyapplication.sql.DatabaseHelper3;

public class AdayActivity extends AppCompatActivity {
    DatabaseHelper3 myDb;
    EditText edityear,editfirst,editsecond ,editTextNO,editthird,editfourth,editfifth,editsixth;
    Button btnAddData;
    Button btnviewAll;
    Button btnDelete;
    Button btnviewUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aday);
        myDb = new DatabaseHelper3(this);

        edityear = (EditText)findViewById(R.id.editText_1);
        editfirst = (EditText)findViewById(R.id.editText_2);
        editsecond = (EditText)findViewById(R.id.editText_3);
        editthird= (EditText)findViewById(R.id.editText_4);
        editfourth = (EditText)findViewById(R.id.editText_5);
        editfifth= (EditText)findViewById(R.id.editText_6);
        editsixth= (EditText)findViewById(R.id.editText_7);
        editTextNO= (EditText)findViewById(R.id.editText_8);

        btnAddData = (Button)findViewById(R.id.button_add);
        btnviewAll = (Button)findViewById(R.id.button_viewAll);
        btnviewUpdate= (Button)findViewById(R.id.button_update);
        btnDelete= (Button)findViewById(R.id.button_delete);

        AddData();
        viewAll();
        UpdateData();
    }


    public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editTextNO.getText().toString(),
                                edityear.getText().toString(),editfirst.getText().toString(),
                                editsecond.getText().toString(), editthird.getText().toString(),editfourth.getText().toString(),editfifth.getText().toString(),editsixth.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(AdayActivity.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AdayActivity.this,"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(edityear.getText().toString(),editfirst.getText().toString(),
                                editsecond.getText().toString(), editthird.getText().toString(),editfourth.getText().toString(),editfifth.getText().toString(),editsixth.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(AdayActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AdayActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
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
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("NO :"+ res.getString(0)+"\n");
                            buffer.append("Year_Semester :"+ res.getString(1)+"\n");
                            buffer.append("First_Class :"+ res.getString(2)+"\n");
                            buffer.append("Second_Class :"+ res.getString(3)+"\n");
                            buffer.append("Third_Class :"+ res.getString(4)+"\n");
                            buffer.append("Fourth_Class :"+ res.getString(5)+"\n");
                            buffer.append("Fifth_Class :"+ res.getString(6)+"\n");
                            buffer.append("Sixth_Class :"+ res.getString(7)+"\n\n");
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
