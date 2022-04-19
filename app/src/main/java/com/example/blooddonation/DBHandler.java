package com.example.blooddonation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHandler extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DBNAME="usersdb";
    private static final String bloodrecords="bloodrecords";
    private static final String id="id";
    private static final String dononame="dononame";
    private static final String recname="recname";
    private static final String bloodtype="bloodtype";
    private static final String donodate="donodate";
    private static final String recdate="recdate";

    /*
    public DbHandler(Context context){
        super(context,DBNAME, null, DB_VERSION);
    }
    */

    public DBHandler(Context context){ super(context, "usersdb", null, 1);
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
        ContentValues contentValues=new ContentValues();
        contentValues.put("id", id);
        contentValues.put("dononame", dononame);
        contentValues.put("recname", recname);
        contentValues.put("bloodtype", bloodtype);
        contentValues.put("donodate", donodate);
        contentValues.put("recdate", recdate);
        long resultset=db.insert("bloodrecords", null, contentValues);
        db.close();
    }

    public ArrayList<HashMap<String, String>> getdetails(){
        SQLiteDatabase db=getWritableDatabase();
        ArrayList<HashMap<String, String>> br=new ArrayList<>();
        String query="SELECT dononame, bloodtype, id FROM "+ bloodrecords;
        Cursor c=db.rawQuery(query,null);
        while (c.moveToNext()){
            HashMap<String,String> bloodrecord=new HashMap<>();
            bloodrecord.put("dononame",c.getString(c.getColumnIndex(dononame)));
            bloodrecord.put("bloodtype",c.getString(c.getColumnIndex(bloodtype)));
            bloodrecord.put("id",c.getString(c.getColumnIndex(id)));
            br.add(bloodrecord);
        }
        return br;
        }

        public void deletedetails(){
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(bloodrecords, id+"=?",new String[]{String.valueOf(id)});
            db.close();
        }
}
