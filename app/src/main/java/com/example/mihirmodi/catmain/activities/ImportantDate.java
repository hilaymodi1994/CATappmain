package com.example.mihirmodi.catmain.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.webkit.WebView;

import com.example.mihirmodi.catmain.R;

public class ImportantDate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.importantdate);
        WebView webView= (WebView)findViewById(R.id.webview1);
        webView.loadUrl("file:///android_asset/impdates.html");
        webView.getSettings().setJavaScriptEnabled(true);

    }

}
