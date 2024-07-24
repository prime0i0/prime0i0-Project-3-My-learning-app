package com.example.primecoding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class operators extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operators);
        getSupportActionBar().setTitle("C Language");


        PDFView pdfView = findViewById(R.id.operators);
        pdfView.fromAsset("operators.pdf").load();
    }
}