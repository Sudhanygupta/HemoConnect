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
    Button signup;
    DBhelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signup=findViewById(R.id.button9);
        un=findViewById(R.id.editTextTextPersonName9);
        pass=findViewById(R.id.editTextTextPersonName10);
        repass=findViewById(R.id.editTextTextPersonName11);
        db=new DBhelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=un.getText().toString();
                String password=pass.getText().toString();
                String repassword=repass.getText().toString();

                if(username.equals("")||password.equals(""))
                    Toast.makeText(SignupActivity.this, "Enter all credentials.", Toast.LENGTH_SHORT).show();
                else{
                    if(password.equals(repassword)){
                        Boolean checkuser=db.check(username);
                        if(checkuser==false){
                            Boolean insert=db.insert(username, password);
                            if(insert==true) {
                                Toast.makeText(SignupActivity.this, "Registered.", Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(i);
                            }
                            else{
                                Toast.makeText(SignupActivity.this, "Error.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(SignupActivity.this, "User exists. Please login.", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(SignupActivity.this, "Passwords do not match.", Toast.LENGTH_SHORT).show();
                    }
                }
                loginActivity();
            }
        });
    }

    public void loginActivity(){
        Intent i=new Intent(this, LoginActiviy.class);
        startActivity(i);
    }

}