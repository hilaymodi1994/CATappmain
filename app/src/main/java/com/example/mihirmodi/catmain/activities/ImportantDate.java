package com.example.mihirmodi.catmain.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.example.mihirmodi.catmain.R;

public class ImportantDate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.importantdate);
        WebView webView= (WebView)findViewById(R.id.webview1);
        webView.loadUrl("file:///android_asset/impdates.html");
        webView.getSettings().setJavaScriptEnabled(true);

    }

}
