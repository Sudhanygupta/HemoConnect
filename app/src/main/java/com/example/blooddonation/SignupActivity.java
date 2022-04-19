package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    EditText un, pass, repass;
    Button login, signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        login=findViewById(R.id.button8);
        un=findViewById(R.id.editTextTextPersonName9);
        pass=findViewById(R.id.editTextTextPersonName10);
        repass=findViewById(R.id.editTextTextPersonName11);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginActivity();
            }
        });

    }

    public void loginActivity(){
        Intent i=new Intent(this, LoginActiviy.class);
        startActivity(i);
    }
}