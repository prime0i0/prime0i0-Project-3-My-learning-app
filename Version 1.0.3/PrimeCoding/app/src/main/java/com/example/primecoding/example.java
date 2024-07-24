package com.example.primecoding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class example extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        getSupportActionBar().setTitle("C Language");


        PDFView pdfView = findViewById(R.id.example);
        pdfView.fromAsset("example1.pdf").load();
    }
}