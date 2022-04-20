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
        db.execSQL("create table bloodrecords(dononame varchar, recname varchar, id varchar, bloodtype varchar, donodate varchar, recdate varchar)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("drop table if exists bloodrecords");
    }

    public boolean insert(String dononame, String recname, String id, String bloodtype, String donodate, String recdate){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("dononame", dononame);
        contentValues.put("recname", recname);
        contentValues.put("id", id);
        contentValues.put("bloodtype", bloodtype);
        contentValues.put("donodate", donodate);
        contentValues.put("recdate", recdate);
        long resultset=db.insert("bloodrecords", null, contentValues);
        if(resultset==-1)
            return false;
        else return true;
    }

    public ArrayList<HashMap<String, String>> getdetails(){
        SQLiteDatabase db=this.getWritableDatabase();
        ArrayList<HashMap<String, String>> AL=new ArrayList<>();
        String query="SELECT dononame, id, bloodtype FROM bloodrecords";
        Cursor c=db.rawQuery(query,null);
        while (c.moveToNext()){
            HashMap<String,String> br=new HashMap<>();
            br.put("dononame", c.getString(c.getColumnIndexOrThrow(dononame)));
            br.put("id",c.getString(c.getColumnIndexOrThrow(id)));
            br.put("bloodtype",c.getString(c.getColumnIndexOrThrow(bloodtype)));
            AL.add(br);
        }
        return AL;
        }

    public ArrayList<HashMap<String, String>> getrecordbyid(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        ArrayList<HashMap<String, String>> AL=new ArrayList<>();
        String query="SELECT dononame, id, donodate FROM bloodrecords";
        Cursor c=db.query(bloodrecords, new String[]{dononame, id, donodate}, id+ "=?",new String[]{String.valueOf(id)},null, null, null, null);
        if (c.moveToNext()){
            HashMap<String,String> r=new HashMap<>();
            r.put("dononame",c.getString(c.getColumnIndexOrThrow(dononame)));
            r.put("id",c.getString(c.getColumnIndexOrThrow(id)));
            r.put("donodate",c.getString(c.getColumnIndexOrThrow(donodate)));
            AL.add(r);
        }
        return AL;
    }

    public void deletedetails(){
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(bloodrecords, id+"=?",new String[]{String.valueOf(id)});
            db.close();
        }

}
