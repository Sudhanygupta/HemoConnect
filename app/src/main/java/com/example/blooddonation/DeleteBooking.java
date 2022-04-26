package com.example.blooddonation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class DeleteBooking extends AppCompatActivity {

    EditText eid;
    Button delete;
    DBHandler db;
    TextView warning;
    Switch s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_booking);

        db=new DBHandler(DeleteBooking.this);

        s=findViewById(R.id.switch3);
        warning=findViewById(R.id.textView69);
        eid=findViewById(R.id.editTextTextPersonName25);
        String id=eid.getText().toString();

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(DeleteBooking.this);
                builder.setCancelable(true);
                builder.setTitle("Alert!");
                builder.setMessage("Once deleted, records will be lost forever.");

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        s.setChecked(false);
                        Intent intn=new Intent(DeleteBooking.this, MainActivity.class);
                        startActivity(intn);
                    }
                });

                builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        warning.setVisibility(View.VISIBLE);
                    }
                });
                builder.show();
            }
        });

        delete=findViewById(R.id.button25);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(s.isChecked()){
                    Integer deleterows=db.deletedetails(eid.getText().toString());
                    Intent i=new Intent(DeleteBooking.this, MainActivity.class);
                    startActivity(i);
                    if (deleterows > 0) {
                        Toast.makeText(DeleteBooking.this, "Data deleted", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DeleteBooking.this, "Data not deleted", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(DeleteBooking.this, "Please click on confirmation switch", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}