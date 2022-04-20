package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteRecords extends AppCompatActivity {

    EditText eid;
    Button delete, home;
    String id="";
    DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_records);

        db=new DBHandler(this);
        id=eid.getText().toString();
        eid=findViewById(R.id.editTextTextPersonName3);

        home=findViewById(R.id.button12);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DeleteRecords.this, MainActivity.class);
                startActivity(i);
            }
        });

        delete=findViewById(R.id.button7);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(eid.getText().toString()!=null){
                    Toast.makeText(DeleteRecords.this, "Deleted.",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(DeleteRecords.this, "Please enter ID to delete",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}