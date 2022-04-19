package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewRecords extends AppCompatActivity {

    Button singlerec, allrecs;
    EditText id;
    TextView srec, allrec;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_records);

        //srec=findViewById(R.id.textView);
        allrec=findViewById(R.id.textView2);
        //id=findViewById(R.id.editTextTextPersonName);
        //singlerec=findViewById(R.id.button4);
        allrecs=findViewById(R.id.button5);
        //String id=srec.getText().toString();

        DBHandler db=new DBHandler(this);
        ArrayList<HashMap<String, String>> userList = db.getdetails();
        ListView lv=(ListView) findViewById(R.id.user_list);
        ListAdapter adapter=new SimpleAdapter(ViewRecords.this, userList, R.layout.list_row,new String[]{"dononame","bloodtype","id"}, new int[]{R.id.dononame, R.id.bloodtype, R.id.id});
        lv.setAdapter(adapter);
    }
}