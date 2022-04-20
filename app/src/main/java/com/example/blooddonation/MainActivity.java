package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button viewrecords, addrecords, deleterecords;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewrecords=findViewById(R.id.button);
        addrecords=findViewById(R.id.button2);
        deleterecords=findViewById(R.id.button3);

        viewrecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, ViewRecords.class);
                startActivity(i);
            }
        });

        addrecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, AddRecords.class);
                startActivity(i);
            }
        });

        deleterecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, DeleteRecords.class);
                startActivity(i);
            }
        });
    }
}