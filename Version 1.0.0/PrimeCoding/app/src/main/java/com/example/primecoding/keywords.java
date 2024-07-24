package com.example.primecoding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class keywords extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keywords);
        getSupportActionBar().setTitle("C Language");

        PDFView pdfView = findViewById(R.id.keywords);
        pdfView.fromAsset("keywords.pdf").load();

    }
}