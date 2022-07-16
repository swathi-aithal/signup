package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sign_in extends AppCompatActivity {

    EditText Username, Password;
    Button SignInbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in2);
        Username=findViewById(R.id.username);
        Password=findViewById(R.id.password);
        SignInbtn=(Button)findViewById(R.id.SignInBtn);
        Bundle bundle=getIntent().getExtras();
        String uname= bundle.getString("username");
        String pwd= bundle.getString("password");
        SignInbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=Username.getText().toString();
                String pass=Password.getText().toString();
                if(user.equals(uname)&&pass.equals(pwd))
                {
                    Toast.makeText(sign_in.this,"Success",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(sign_in.this,"Failure",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}