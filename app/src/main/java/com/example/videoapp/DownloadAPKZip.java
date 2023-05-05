package com.example.videoapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class DownloadAPKZip extends AppCompatActivity {
    WebView webView; DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_a_p_k_zip);
        drawerLayout=(DrawerLayout)findViewById(R.id.draw);
        String title=getIntent().getStringExtra("title");
        webView=(WebView)findViewById(R.id.web);
        switch (title) {
            case "CV Maker App":
                callDialog("CV Maker App");break;
            case "Convertor App":
                webView.loadUrl("https://drive.google.com/drive/folders/1IOCTVAuhzeJU778tf6Z1eJBWOvoYaPOn?usp=share_link");
                break;
            case "Inventory Management App":
                webView.loadUrl("https://drive.google.com/drive/folders/1uqYJdgFAhhUrE2b-LF2CCZLHZwSeBkDo?usp=share_link");
                break;
            case "Novel Scholar App":
                webView.loadUrl("https://drive.google.com/drive/folders/1hjQaLkMrxCoWkVMHOlHw9SsIu7_1HPpi?usp=share_link");
                break;
            case "Notification App":
                webView.loadUrl("https://drive.google.com/drive/folders/1esyuQ0m8HcZQ2q_qm7ukQkCN0i16OtKS?usp=share_link");
                break;
            case "Greetings App":
                webView.loadUrl("https://drive.google.com/drive/folders/1DugFEhdm2H_RsW0k5_idwKDeG1KOcweE?usp=share_link");
                break;
            case "Shlok Mantra App":
                webView.loadUrl("https://drive.google.com/drive/folders/15gk6Dyg06geuXoZz5CuIXmMAnfLBMYTs?usp=share_link");
                break;
            case "Quiz App":
                webView.loadUrl("https://drive.google.com/drive/folders/1xYtW6cZ61GGAfeZN1TFuTO1qSzDP9eXq?usp=share_link");
                break;
            case "Storing JSP form data to h2 in-memory database":
                webView.loadUrl("https://gitlab.com/PRIYANKA-Nigam/spring-boot-apis/-/blob/main/api_using_jsp_jpa_h2_in_memory_db.pdf");break;
            case "Store data to h2 in-memory database using jdbctemplate class":
                webView.loadUrl("https://gitlab.com/PRIYANKA-Nigam/spring-boot-apis/-/blob/main/get_api_using_jdbcTemplate_h2_in_memory_db.pdf");break;
            case "CRUD operation with postman using ResponseEntity class":
                webView.loadUrl("https://gitlab.com/PRIYANKA-Nigam/spring-boot-apis/-/blob/main/post_get_api_with_responseEntity_class.pdf");break;
            case "Fetch stored data from h2 in-memory database using jpa repository and jdbctemplate":
                webView.loadUrl("https://gitlab.com/PRIYANKA-Nigam/spring-boot-apis/-/blob/main/get_api_using_jdbcTemplate_h2_in_memory_db-merged.pdf");break;
            case "Implementation of basic GET API":
                webView.loadUrl("https://gitlab.com/PRIYANKA-Nigam/spring-boot-apis/-/blob/main/get_api_response.pdf");break;
            case "Calculator App":
                callDialog("Calculator App");break;
            case "Monthlies Tracker App":
                callDialog("Monthlies Tracker App");break;
            case "Banking App":
                callDialog("Banking App");break;
            case "ATM Cash Dispenser App":
                callDialog("ATM Cash Dispenser App");break;
            case "Dictionary App":
                callDialog("Dictionary App");break;
            case "Text to Json Convertor App":
                callDialog("Text to Json Convertor App");break;
            case "PHP Basics":
                callDialog("PHP Basics");break;
        }
        webView.setWebViewClient(new client()); WebSettings webSettings=webView.getSettings();
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

    public void callDialog(String s) {
        AlertDialog.Builder builder = new AlertDialog.Builder(DownloadAPKZip.this);
        builder.setCancelable(false);
        builder.setTitle("No APK exists for the choosen - "+s);
        builder.setMessage("Check Web Apps on browser.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });
        builder.show();
    }


    public static class client extends WebViewClient {
        @Override public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon); }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true; }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url); }
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
    public static void logout(final DownloadAPKZip mainActivity) { android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(mainActivity);
        builder.setTitle("Logout");builder.setMessage("Are You Sure You Want to Logout ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)  @Override
            public void onClick(DialogInterface dialog, int which) {
                mainActivity.finishAffinity();System.exit(0); }});
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { @Override
        public void onClick(DialogInterface dialog, int which) { dialog.dismiss(); }}); builder.show(); }
}