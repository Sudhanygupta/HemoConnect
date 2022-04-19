package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ViewRecords extends AppCompatActivity {

    Button singlerec, allrecs;
    EditText id;
    TextView srec, allrec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_records);

        srec=findViewById(R.id.textView);
        allrec=findViewById(R.id.textView2);
        id=findViewById(R.id.editTextTextPersonName);
        singlerec=findViewById(R.id.button4);
        allrecs=findViewById(R.id.button5);
        String id=srec.getText().toString();
    }
}