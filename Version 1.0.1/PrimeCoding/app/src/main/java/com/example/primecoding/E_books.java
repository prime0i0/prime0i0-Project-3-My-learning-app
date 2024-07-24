package com.example.primecoding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.IntentCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class E_books extends AppCompatActivity {

    ImageView book1 , book2 , book3 , book4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebooks);
        getSupportActionBar().setTitle("📚 E Books");

        book1=(ImageView) findViewById(R.id.book11);
        book2=(ImageView) findViewById(R.id.book22);
        book3=(ImageView) findViewById(R.id.book33);
        book4=(ImageView) findViewById(R.id.book44);
        book4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(E_books.this , book4.class);
                startActivity(intent);
            }
        });
        book3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(E_books.this , book3.class);
                startActivity(intent);
            }
        });
        book2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(E_books.this , book2.class);
                startActivity(intent);
            }
        });
        book1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(E_books.this , book1.class);
                startActivity(intent);
            }
        });

    }
}