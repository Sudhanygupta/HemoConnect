package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActiviy extends AppCompatActivity {

    EditText un, pass;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activiy);
        un=findViewById(R.id.editTextTextPersonName12);
        pass=findViewById(R.id.editTextTextPersonName13);
        login=findViewById(R.id.button10);
    }
}