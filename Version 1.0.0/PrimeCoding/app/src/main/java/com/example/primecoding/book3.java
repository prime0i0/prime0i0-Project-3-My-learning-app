package com.example.primecoding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class book3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book3);
        getSupportActionBar().setTitle("C Language");


        PDFView pdfView = findViewById(R.id.book3);
        pdfView.fromAsset("book3.pdf").load();
    }
}