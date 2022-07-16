package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button Signupbtn;
    String regex="^(?=.*[0-9])"
            +"(?=.*[a-z])(?=.*[A-Z])"
            +"(?=.*[@#$%&])"
            +"(?=\\S+$).{8,20}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        Signupbtn=(Button)findViewById(R.id.Signupbtn);
        Signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Uname=username.getText().toString();
                String pwd=password.getText().toString();
                if(ValidatePassword(pwd)) {
                    Intent intent = new Intent(MainActivity.this,sign_in.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("username",Uname);
                    bundle.putString("password",pwd);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this,"Invalid Password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public boolean ValidatePassword(String pwd)
    {
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(pwd);
        return matcher.matches();
    }
}