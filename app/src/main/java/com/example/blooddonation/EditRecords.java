package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditRecords extends AppCompatActivity {

    Button update;
    EditText dname, rname, eid, ebloodtype, ddate, rdate;
    Intent intent;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_records);

        update=findViewById(R.id.button14);
        dname=findViewById(R.id.editTextTextPersonName15);
        rname=findViewById(R.id.editTextTextPersonName16);
        eid=findViewById(R.id.editTextTextPersonName14);
        ebloodtype=findViewById(R.id.editTextTextPersonName17);
        ddate=findViewById(R.id.editTextTextPersonName18);
        rdate=findViewById(R.id.editTextTextPersonName19);
        db=new DBHandler(this);
        eid.requestFocus();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}