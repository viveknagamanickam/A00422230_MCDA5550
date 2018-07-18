package com.example.vivek.sqltest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vivek on 7/17/2018.
 */

public class dbHelper extends SQLiteOpenHelper {


    public static final String DB_NAME = "User_db";
    public static final int DATABASE_VERSION = 1;
    public static final String CREATE_TABLE = "CREATE TABLE " + UserContract.UserEntry.TABLE_NAME +
            "("+ UserContract.UserEntry.NAME + " text," + UserContract.UserEntry.DATE + " text," +
            UserContract.UserEntry.HEALTH_CARD_NUMBER + " number," + UserContract.UserEntry.PASSWORD + " text); ";


    public dbHelper(Context context) {
        super(context, DB_NAME,null,DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addUser(String name, String date, String healthCardNumber, String password){

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContract.UserEntry.NAME,name);
        contentValues.put(UserContract.UserEntry.DATE,date);
        contentValues.put(UserContract.UserEntry.HEALTH_CARD_NUMBER,healthCardNumber);
        contentValues.put(UserContract.UserEntry.PASSWORD,password);

        long result = database.insert(UserContract.UserEntry.TABLE_NAME,null,contentValues);

        if(result == -1 ){
            return false;
        }else{
            return true;
        }

    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor data = db.rawQuery("SELECT * FROM " + UserContract.UserEntry.TABLE_NAME,null);
        return data;
    }
}
