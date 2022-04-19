package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActiviy extends AppCompatActivity {

    EditText un, pass;
    Button login, signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activiy);


        un=findViewById(R.id.editTextTextPersonName12);
        pass=findViewById(R.id.editTextTextPersonName13);
        login=findViewById(R.id.button10);
        signup=findViewById(R.id.button11);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });

    }

    public void openSignup(){
        Intent i=new Intent(this, SignupActivity.class);
        startActivity(i);
    }

    public void openMainActivity(){
        Intent i=new Intent(this, MainActivity.class);
        startActivity(i);
    }
}