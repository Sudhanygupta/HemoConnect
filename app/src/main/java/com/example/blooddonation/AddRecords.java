package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class AddRecords extends AppCompatActivity {

    String dononame, recname, id, bloodtype, donodate, recdate;
    EditText dname, rname, eid, ebloodtype, ddate, rdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_records);

        dname=findViewById(R.id.editTextTextPersonName2);
        rname=findViewById(R.id.editTextTextPersonName8);
        eid=findViewById(R.id.editTextTextPersonName4);
        ebloodtype=findViewById(R.id.editTextTextPersonName5);
        ddate=findViewById(R.id.editTextTextPersonName6);
        rdate=findViewById(R.id.editTextTextPersonName7);

    }
}