package com.example.primecoding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class variable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variable);
        getSupportActionBar().setTitle("C Language");


        PDFView pdfView = findViewById(R.id.variable);
        pdfView.fromAsset("variable.pdf").load();
    }
}