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
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activiy);
        un=findViewById(R.id.editTextTextPersonName12);
        pass=findViewById(R.id.editTextTextPersonName13);
        login=findViewById(R.id.button10);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (un.getText().toString().equals("root")&&pass.getText().toString().equals("vpms")){
                    openMainActivity();
                    Toast.makeText(getApplicationContext(),"Welcome",Toast.LENGTH_SHORT).show();
                }
                /*
                else if (un.getText().toString().equals(null)||pass.getText().toString().equals(null)){
                    Toast.makeText(getApplicationContext(),"Please enter credentials",Toast.LENGTH_SHORT).show();
                }
                */
                else{
                    int count=3;
                    count--;
                    Toast.makeText(getApplicationContext(),"Invalid credentials",Toast.LENGTH_SHORT).show();
                    un.setText(null);
                    pass.setText(null);
                    if(count==0){
                        login.setClickable(false);
                    }
                }
            }
        });
    }

    public void openMainActivity(){
        Intent i=new Intent(this, MainActivity.class);
        startActivity(i);
    }
}