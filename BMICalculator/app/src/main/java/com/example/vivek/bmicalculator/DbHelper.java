package com.example.vivek.bmicalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by vivek on 7/29/2018.
 */

public class DbHelper extends SQLiteOpenHelper {



    public static final String DB_NAME = "User_db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "USER";
    public static final String TABLE_NAME_BMI = "BMI_USERS";
//    public static final String NAME = "NAME";
//    public static final String HEALTH_CARD_NUMBER = "HCN";
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(NAME TEXT, HCN INTEGER" +
        ", PASSWORD TEXT, DOB TEXT);";
    public static final String CREATE_BMI_TABLE = "CREATE TABLE " + TABLE_NAME_BMI +
            "(HEIGHT INTEGER, WEIGHT INTEGER);";


    public DbHelper(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){

        sqLiteDatabase.execSQL(CREATE_TABLE);
        sqLiteDatabase.execSQL(CREATE_BMI_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int j){

    }

    public void addUser(String name, int healthCardNumber, String password, String dob){

        try {
            SQLiteDatabase database = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("NAME", name);
            contentValues.put("HCN", healthCardNumber);
            contentValues.put("PASSWORD",password);
            contentValues.put("DOB",dob);

            database.insert(TABLE_NAME, null, contentValues);
        }
        catch(Exception err) {
            Log.e("Error",err.getMessage());
        }
    }


    public void addBmiUser(int height, int weight){
        try {
            SQLiteDatabase database = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("HEIGHT",height);
            contentValues.put("WEIGHT",weight);
            database.insert(TABLE_NAME_BMI,null,contentValues);
        }
        catch (Exception err){
            Log.e("Error",err.getMessage());
        }
    }

    public Cursor getUserData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return data;
    }

    public Cursor getBmiData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+TABLE_NAME_BMI,null);
        return data;
    }

    public String getSingleEntry(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor data = db.query("USER",null,"NAME=?", new String[]{username},null,null,null);
        if(data.getCount()<1)
            return "NOT EXIST";
        data.moveToFirst();
        String getPassword = data.getString(data.getColumnIndex("PASSWORD"));
        return getPassword;
    }

}
