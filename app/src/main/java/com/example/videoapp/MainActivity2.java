package com.example.videoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.pd.lookatme.LookAtMe;

public class MainActivity2 extends AppCompatActivity {
WebView webView;
ToggleButton toggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        toggleButton = findViewById(R.id.tb1);
        webView = findViewById(R.id.full);
        String link=getIntent().getStringExtra("link");
         String title=getIntent().getStringExtra("title");
        Toast.makeText(getApplicationContext(),"Title: "+title,Toast.LENGTH_SHORT).show();
        webView.loadUrl(link);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);
        toggleButton.setTooltipText("Switch to AI Mode");
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Intent intent=new Intent(getApplicationContext(),Ai_Mode_Activity.class);
                intent.putExtra("title",title);
                startActivity(intent);
            }
        });

    }

}