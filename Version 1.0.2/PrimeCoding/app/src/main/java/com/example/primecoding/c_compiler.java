package com.example.primecoding;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class c_compiler extends AppCompatActivity {

    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ccompiler);
        getSupportActionBar().setTitle("Online Compiler");
        customWebViewClient client = new customWebViewClient(this);
        webView=findViewById(R.id.webView);
        webView.setWebViewClient(client);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.onlinegdb.com/online_c_compiler");

    }
    @Override
    public boolean onKeyDown(int keycode , KeyEvent event){
        if(keycode == KeyEvent.KEYCODE_BACK && this.webView.canGoBack()){
            this.webView.goBack();
            return true;
        }
        return super.onKeyDown(keycode , event);
    }
}

class customWebViewClient extends WebViewClient{
    private Activity  activity;

    public customWebViewClient(Activity activity){
        this.activity = activity;
    }

    @Override
    public  boolean shouldOverrideUrlLoading(WebView webView , String url)
    {
        return false;
    }
    @Override
    public boolean shouldOverrideUrlLoading(WebView webView , WebResourceRequest request){
        return false;
    }
}