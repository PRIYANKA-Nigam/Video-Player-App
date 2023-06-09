package com.example.videoapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class Download_Zip extends AppCompatActivity {
    WebView webView; DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download__zip);
        drawerLayout=(DrawerLayout)findViewById(R.id.draw);
        String title=getIntent().getStringExtra("title");
        webView=(WebView)findViewById(R.id.web);
        switch (title) {
            case "Convertor App":
                webView.loadUrl("https://drive.google.com/file/d/17XPMU1vTQAnT8daBrtU5uuKJFhCKcAL2/view?usp=share_link");
                break;
            case "Inventory Management App":
                webView.loadUrl("https://drive.google.com/file/d/100NMk76nYclI8XNR18HsLMdweLH7iMBZ/view?usp=share_link");
                break;
            case "Novel Scholar App":
                webView.loadUrl("https://drive.google.com/file/d/1ZkblVzsUXxeX9RqHbhOxgt738xtK9W5F/view?usp=share_link");
                break;
            case "Notification App":
                webView.loadUrl("https://drive.google.com/file/d/1uYKNXo97pt3mACNfZSlAuXzdKQWKBKKb/view?usp=share_link");
                break;
            case "Greetings App":
                webView.loadUrl("https://drive.google.com/file/d/1AkKHHKJmdsPGFMgEp5dRCN1YWjSpoL9r/view?usp=share_link");
                break;
            case "Shlok Mantra App":
                webView.loadUrl("https://drive.google.com/file/d/1rRRjFfZaiIU-xZBNjz9VKObCNmCqcNmV/view?usp=share_link");
                break;
            case "Quiz App":
                webView.loadUrl("https://drive.google.com/file/d/1n2emUpROF8c2ejabw-3BIZv8IHEL7V31/view?usp=share_link");
                break;
        }
        webView.setWebViewClient(new DownloadAPKZip.client()); WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true); webView.clearCache(true);
        webView.clearHistory();

        webView.setDownloadListener(new DownloadListener() { @Override
        public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
            DownloadManager.Request request=new DownloadManager.Request(Uri.parse(url));
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            DownloadManager dm=(DownloadManager)getSystemService(DOWNLOAD_SERVICE); dm.enqueue(request);
            Toast.makeText(getApplicationContext(),"Downloading Started...",Toast.LENGTH_SHORT).show(); }});

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dark_brightness,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.dark:
                startActivity(new Intent(this,DarkModeActivity.class));
                break;
            case R.id.bright:
                startActivity(new Intent(this,SetBrightnessActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }
    public static void openDrawer(DrawerLayout drawerLayout) { drawerLayout.openDrawer(GravityCompat.START); }
    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }
    public static void closeDrawer(DrawerLayout drawerLayout) { if (drawerLayout.isDrawerOpen(GravityCompat.START)){
        drawerLayout.closeDrawer(GravityCompat.START); } }
    public void ClickHome(View view){
        MainActivity.redirectActivity(this,MainActivity.class);
    }
    public void ClickAPK(View view){
        MainActivity.redirectActivity(this,APKActivity.class);
    }
    public void ClickZip(View view){
        MainActivity.redirectActivity(this,ZipActivity.class);
    }
    public void ClickCode(View view){
        MainActivity.redirectActivity(this,CodeActivity.class);
    }
    public void ClickAboutUs(View view){
        MainActivity.redirectActivity(this,AboutActivity.class);
    }
    public void ClickLinkedIn(View view){MainActivity.redirectActivity2(this,LinkActivity.class,"l");}
    public void ClickInsta(View view){MainActivity.redirectActivity2(this,LinkActivity.class,"i");}
    public void ClickTwitter(View view){MainActivity.redirectActivity2(this,LinkActivity.class,"t");}
    public void ClickFB(View view){MainActivity.redirectActivity2(this,LinkActivity.class,"f");}
    public void ClickWebsite(View view){MainActivity.redirectActivity2(this,LinkActivity.class,"w");}
    public void ClickGithub(View view){MainActivity.redirectActivity2(this,LinkActivity.class,"g");}
    public void ClickGitlab(View view){MainActivity.redirectActivity2(this,LinkActivity.class,"gi");}
    public void ClickHack(View view){MainActivity.redirectActivity2(this,LinkActivity.class,"h");}
    public void ClickLogout(View view){
        MainActivity.logout(this); }

}