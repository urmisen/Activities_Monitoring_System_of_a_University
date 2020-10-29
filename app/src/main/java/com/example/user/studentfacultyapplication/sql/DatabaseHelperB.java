package com.example.user.studentfacultyapplication.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseHelperB extends SQLiteOpenHelper {
    public static final String  DATABASE_NAME="RoutineBday.db";
    public static final String  TABLE_NAME="Routine_table";
    public static final String COL_1 = "NO";
    public static final String COL_2 = "YEAR_SEMESTER";
    public static final String COL_3 = "FIRST_CLASS";
    public static final String COL_4 = "SECOND_CLASS";
    public static final String COL_5= "THIRD_CLASS";
    public static final String COL_6 = "FOURTH_CLASS";
    public static final String COL_7 = "FIFTH_CLASS";
    public static final String COL_8 = "SIXTH_CLASS";

    public DatabaseHelperB(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (NO INTEGER PRIMARY KEY AUTOINCREMENT,YEAR_SEMESTER TEXT,FIRST_CLASS TEXT,SECOND_CLASS TEXT,THIRD_CLASS TEXT,FOURTH_CLASS TEXT,FIFTH_CLASS TEXT,SIXTH_CLASS TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String year,String first,String second,String third,String fourth,String fifth,String sixth) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,year);
        contentValues.put(COL_3,first);
        contentValues.put(COL_4,second);
        contentValues.put(COL_5,third);
        contentValues.put(COL_6,fourth);
        contentValues.put(COL_7,fifth);
        contentValues.put(COL_8,sixth);

        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String no,String year,String first,String second,String third,String fourth,String fifth,String sixth) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,no);
        contentValues.put(COL_2,year);
        contentValues.put(COL_3,first);
        contentValues.put(COL_4,second);
        contentValues.put(COL_5,third);
        contentValues.put(COL_6,fourth);
        contentValues.put(COL_7,fifth);
        contentValues.put(COL_8,sixth);
        db.update(TABLE_NAME, contentValues, "NO = ?",new String[] { no });
        return true;
    }


}


