package com.example.blooddonation;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME="usersdb";
    private static final String bloodrecords="userdetails";
    private static final String id="id";
    private static final String dononame="dononame";
    private static final String recname="recname";
    private static final String bloodtype="bloodtype";
    private static final String donodate="donodate";
    private static final String recdate="recdate";
    public DbHandler(Context context){
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE "+bloodrecords +"("+id+"VARCHAR,"+dononame+"VARCHAR, "+recname+"VARCHAR, "+bloodtype+"VARCHAR, "+donodate+"VARCHAR, "+recdate+"VARCHAR"+")";
        db.execSQL(createTable);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + bloodrecords);
        onCreate(db);
    }

    void adddetails(String dononame, String recname, String id, String bloodtype, String donodate, String recdate){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues;
    }

}
