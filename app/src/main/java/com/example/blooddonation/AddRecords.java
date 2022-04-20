package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddRecords extends AppCompatActivity {


    Button add;
    EditText dname, rname, eid, ebloodtype, ddate, rdate;
    Intent intent;
    DBHandler db;
    private Object SQLiteDataBaseQueryHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_records);

        add=findViewById(R.id.button6);
        dname=findViewById(R.id.editTextTextPersonName2);
        rname=findViewById(R.id.editTextTextPersonName8);
        eid=findViewById(R.id.editTextTextPersonName4);
        ebloodtype=findViewById(R.id.editTextTextPersonName5);
        ddate=findViewById(R.id.editTextTextPersonName6);
        rdate=findViewById(R.id.editTextTextPersonName7);
        db=new DBHandler(this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //insert();
                String dononame=dname.getText().toString();
                String recname=rname.getText().toString();
                String id=eid.getText().toString();
                String bloodtype=ebloodtype.getText().toString();
                String donodate=ddate.getText().toString();
                String recdate=rdate.getText().toString();
                //DBHandler dbHandler=new DBHandler(AddRecords.this);
                //dbHandler.insert(dononame, recname, id, bloodtype, donodate, recdate);
                Boolean insert=db.insert(dononame, recname, id, bloodtype, donodate, recdate);
                if(insert==true){
                    Toast.makeText(getApplicationContext(), "Details Inserted Successfully",Toast.LENGTH_SHORT).show();
                    intent=new Intent(AddRecords.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    /*
    public void createDb(){
        SQLiteDatabase ob=openOrCreateDatabase("AndroidJSonDataBase", Context.MODE_PRIVATE, null);
    }

    public void createtable(){
        SQLiteDatabase ob=null;
        ob.execSQL("CREATE TABLE IF NOT EXISTS bloodrecords(dononame VARCHAR, recname VARCHAR,id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, bloodtype VARCHAR, donodate VARCHAR, recdate VARCHAR);");
    }

    public void insertdata(){
        String donname=dname.getText().toString();
        String recname=rname.getText().toString();
        String id=eid.getText().toString();
        String bldtyp=ebloodtype.getText().toString();
        String donodate=ddate.getText().toString();
        String recdate=rdate.getText().toString();

        SQLiteDataBaseQueryHolder = "INSERT INTO AndroidJSonTable (name,phone_number) VALUES('"+donname+"', '"+recname+"', '"+id+"', '"+bldtyp+"', '"+donodate+"', '"+recdate+"',);";

        SQLiteDatabase sqLiteDatabaseObj=null;
        sqLiteDatabaseObj.execSQL((String) SQLiteDataBaseQueryHolder);
        Toast.makeText(this,"Data inserted", Toast.LENGTH_SHORT).show();

        dname.setText("");
        rname.setText("");
        eid.setText("");
        ebloodtype.setText("");
        ddate.setText("");
        rdate.setText("");

    }
    */

    /*
    public void insert() {
        try {
            String donname=dname.getText().toString();
            String recname=rname.getText().toString();
            String id=eid.getText().toString();
            String bldtyp=ebloodtype.getText().toString();
            String donodate=ddate.getText().toString();
            String recdate=rdate.getText().toString();

            SQLiteDatabase db=openOrCreateDatabase("database", Context.MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS bloodrecords(dononame VARCHAR, recname VARCHAR, id INTEGER PRIMARY KEY AUTOINCREMENT,bldtype VARCHAR,donodate VARCHAR, recdate VARCHAR)");
            String sql="insert into bloodrecords(donname, recname, id, bldtyp, donodate, recdate)values(?,?,?,?,?,?)";
            SQLiteStatement stmt = db.compileStatement(sql);
            stmt.bindString(1, donname);
            stmt.bindString(2, recname);
            stmt.bindString(3, id);
            stmt.bindString(4, bldtyp);
            stmt.bindString(5, donodate);
            stmt.bindString(6, recdate);
            stmt.execute();
            Toast.makeText(this,"Added",Toast.LENGTH_SHORT).show();
            dname.setText("");
            rname.setText("");
            eid.setText("");
            ebloodtype.setText("");
            ddate.setText("");
            rdate.setText("");
        }
        catch (Exception e){
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
        }
    }
    */
}