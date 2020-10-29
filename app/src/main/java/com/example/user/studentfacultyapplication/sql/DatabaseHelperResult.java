package com.example.user.studentfacultyapplication.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 7/5/2017.
 */

public class DatabaseHelperResult extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Result.db";
    public static final String TABLE_NAME="result_table";
    public static final String COL_1="ID";
    public static final String COL_2="NAME";
    public static final String COL_3="GPA";
    public static final String COL_4="CGPA";
    public static final String COL_5="BACKLOG";

    public DatabaseHelperResult(Context context) {
        super(context,DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,GPA INTEGER,CGPA INTEGER,BACKLOG TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVertion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String name,String gpa,String cgpa,String backlog){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,gpa);
        contentValues.put(COL_4,cgpa);
        contentValues.put(COL_5,backlog);

        long result=db.insert(TABLE_NAME,null, contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id,String name,String gpa,String cgpa,String backlog) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,gpa);
        contentValues.put(COL_4,cgpa);
        contentValues.put(COL_5,backlog);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }


}


