package com.example.primecoding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class comments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        getSupportActionBar().setTitle("C Language");


        PDFView pdfView = findViewById(R.id.comments);
        pdfView.fromAsset("comments.pdf").load();
    }
}