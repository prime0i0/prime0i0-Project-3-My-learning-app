package com.example.primecoding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText e2 , e3 ;
    private Button b3;
    private TextView t1;
    private FirebaseAuth firebaseAuth;

    public  static  final  String SHARED_PREFS = "sharedPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("🏡 Home");
        e2=(EditText)findViewById(R.id.username);
        e3=(EditText)findViewById(R.id.password);
        firebaseAuth=FirebaseAuth.getInstance();
        b3=(Button) findViewById(R.id.loginbtn);
        t1=(TextView)findViewById(R.id.register);
        checkBox();
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , signup.class);
                startActivity(intent);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginuser();
            }
        });

    }

    private void checkBox() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS , MODE_PRIVATE);
        String check = sharedPreferences.getString("name","");
        if(check.equals("true"))
        {
            Intent intent = new Intent(MainActivity.this , home.class);
            startActivity(intent);
            finish();
        }
    }

    private void loginuser(){

        String email = e2.getText().toString();
        String pass = e3.getText().toString();

        if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            if(!pass.isEmpty())
            {
                firebaseAuth.signInWithEmailAndPassword(email , pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {

                        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS , MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("name", "true");
                        editor.apply();


                        Toast.makeText(MainActivity.this, "Login Successfully !!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this , home.class);
                        startActivity(intent);
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Login Failed !!", Toast.LENGTH_SHORT).show();
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