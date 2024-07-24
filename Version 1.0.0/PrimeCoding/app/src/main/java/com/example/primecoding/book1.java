package com.example.primecoding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class book1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book1);
        getSupportActionBar().setTitle("C Language");


        PDFView pdfView = findViewById(R.id.book1);
        pdfView.fromAsset("book1.pdf").load();
    }
}