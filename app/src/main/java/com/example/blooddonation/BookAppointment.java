package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BookAppointment extends AppCompatActivity {
    Button book, check, back;
    EditText dname, eid, ebloodtype, ddate;
    Intent intent;
    DBbook db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        db=new DBbook(this);

        dname=findViewById(R.id.editTextTextPersonName20);
        eid=findViewById(R.id.editTextTextPersonName21);
        ebloodtype=findViewById(R.id.editTextTextPersonName22);
        ddate=findViewById(R.id.editTextTextPersonName23);

        dname.requestFocus();

        book=findViewById(R.id.button19);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dononame=dname.getText().toString();
                String id=eid.getText().toString();
                String bloodtype=ebloodtype.getText().toString();
                String donodate=ddate.getText().toString();
                Boolean insert=db.insert(dononame,id, bloodtype, donodate);
                if(insert==true){
                    Toast.makeText(BookAppointment.this, "Appointment booked.",Toast.LENGTH_SHORT).show();
                    intent=new Intent(BookAppointment.this, CheckAvail.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(BookAppointment.this, "Can't book appointment.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        check=findViewById(R.id.button20);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ab=new Intent(BookAppointment.this, CheckAppointment.class);
                startActivity(ab);
            }
        });

        back=findViewById(R.id.button23);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b=new Intent(BookAppointment.this, MainActivity.class);
                startActivity(b);
            }
        });

    }
}