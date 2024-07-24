package com.example.primecoding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {

    private EditText e2 , e3 ;
    private Button b3;
    private TextView t1;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().setTitle("SignUp");
        e2=(EditText) findViewById(R.id.username);
        e3=(EditText) findViewById(R.id.password);
        b3=(Button)findViewById(R.id.signupbtn);
        firebaseAuth = FirebaseAuth.getInstance();
        t1=(TextView)findViewById(R.id.forgotpass);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signup.this , MainActivity.class);
                startActivity(intent);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createuser();
            }
        });
    }
    private void createuser(){

        String email = e2.getText().toString();
        String pass = e3.getText().toString();

        if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            if(!pass.isEmpty())
            {
                firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(signup.this, "Registered Successfully  !!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent( signup.this , MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(signup.this, "Registration Error !!", Toast.LENGTH_SHORT).show();
                    }
                });
            }else {
                e3.setError("Empty Space is Not Allowd !");
            }
        }else if (email.isEmpty()){
            e2.setError("Empty Space is Not Allowed !");
        }else{
            e2.setError("Please Enter Correct Email");
        }

    }
}