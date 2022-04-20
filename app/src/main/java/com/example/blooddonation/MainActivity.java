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
                openViewRecords();
            }
        });

        addrecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddRecords();
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

    public void openViewRecords(){
        Intent i=new Intent(this, ViewRecords.class);
        startActivity(i);
    }

    public void openAddRecords(){
        Intent i=new Intent(this, AddRecords.class);
        startActivity(i);
    }

}