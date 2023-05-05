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

public class Download_APK extends AppCompatActivity {
    WebView webView; DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download__a_p_k);
        drawerLayout=(DrawerLayout)findViewById(R.id.draw);
        String title=getIntent().getStringExtra("title");
        webView=(WebView)findViewById(R.id.web);
        switch (title) {
            case "Convertor App":
                webView.loadUrl("https://drive.google.com/file/d/14vAgcUD60_IdD-3blXNkQb56HKV7FMkc/view?usp=share_link");
                break;
            case "Inventory Management App":
                webView.loadUrl("https://drive.google.com/file/d/1Xi8vV-ckfmChioOtj8F_PQ7y4MEXXKxr/view?usp=share_link");
                break;
            case "Novel Scholar App":
                webView.loadUrl("https://drive.google.com/file/d/1_gPLKAwDxVMyisNBzG7vF5VWn9LLSoil/view?usp=share_link");
                break;
            case "Notification App":
                webView.loadUrl("https://drive.google.com/file/d/1MV3j20Ytk7_2FQJZ3Ua1bXyVH-Ruw9la/view?usp=share_link");
                break;
            case "Greetings App":
                webView.loadUrl("https://drive.google.com/file/d/1iXjXp30p2Z8g7Ld4Mvpr-64Cd4OPEGE_/view?usp=share_link");
                break;
            case "Shlok Mantra App":
                webView.loadUrl("https://drive.google.com/file/d/177socPg2FjmvtkHTlFiLf2CdnF4LAscv/view?usp=share_link");
                break;
            case "Quiz App":
                webView.loadUrl("https://drive.google.com/file/d/1bLyZvfsX85yqMRSqfAIov8O-yAdXWJYw/view?usp=share_link");
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
        logout(this); }
    public static void logout(final Download_APK mainActivity) { android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(mainActivity);
        builder.setTitle("Logout");builder.setMessage("Are You Sure You Want to Logout ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)  @Override
            public void onClick(DialogInterface dialog, int which) {
                mainActivity.finishAffinity();System.exit(0); }});
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { @Override
        public void onClick(DialogInterface dialog, int which) { dialog.dismiss(); }}); builder.show(); }
}