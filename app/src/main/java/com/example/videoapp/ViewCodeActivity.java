package com.example.videoapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class ViewCodeActivity extends AppCompatActivity {
    WebView webView;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_code);
        drawerLayout=(DrawerLayout)findViewById(R.id.draw);
        webView=(WebView)findViewById(R.id.web);
        String title=getIntent().getStringExtra("title");
        switch (title){
            case "CV Maker App":
                webView.loadUrl("https://gitlab.com/PRIYANKA-Nigam/cv-maker-app"); break;
            case "Convertor App":
                webView.loadUrl("https://github.com/PRIYANKA-Nigam/Convertor-App"); break;
            case "Calculator App":
                webView.loadUrl("https://gitlab.com/PRIYANKA-Nigam/calculator-app");break;
            case "Monthlies Tracker App":
                webView.loadUrl("https://gitlab.com/PRIYANKA-Nigam/monthlies-tracker-app");break;
            case "Inventory Management App":
                webView.loadUrl("https://github.com/PRIYANKA-Nigam/InventoryManagement-App");break;
            case "Novel Scholar App":
                webView.loadUrl("https://github.com/PRIYANKA-Nigam/Novel-Scholar-App");break;
            case "Notification App":
                webView.loadUrl("https://github.com/PRIYANKA-Nigam/Notification-APP");break;
            case "Greetings App":
                webView.loadUrl("https://github.com/PRIYANKA-Nigam/Greetings-App");break;
            case "Shlok Mantra App":
                webView.loadUrl("https://github.com/PRIYANKA-Nigam/Shlok-Mantra-App");break;
            case "Quiz App":
                webView.loadUrl("https://github.com/PRIYANKA-Nigam/Quiz-App");break;
            case "Banking App":
                webView.loadUrl("https://gitlab.com/PRIYANKA-Nigam/banking-app");break;
            case "ATM Cash Dispenser App":
                webView.loadUrl("https://gitlab.com/PRIYANKA-Nigam/atm-cash-dispenser-app");break;
            case "Dictionary App":
                webView.loadUrl("https://gitlab.com/PRIYANKA-Nigam/dictionary-app");break;
            case "Text to Json Convertor App":
                webView.loadUrl("https://gitlab.com/PRIYANKA-Nigam/text-to-json-convertor");break;
            case "PHP Basics":
                webView.loadUrl("https://gitlab.com/PRIYANKA-Nigam/php-basics");break;
            case "Storing JSP form data to h2 in-memory database":
                webView.loadUrl("https://gitlab.com/PRIYANKA-Nigam/spring-boot-apis/-/snippets/2533377");break;
            case "Store data to h2 in-memory database using jdbctemplate class":
                webView.loadUrl("https://gitlab.com/-/snippets/2533384");break;
            case "CRUD operation with postman using ResponseEntity class":
                webView.loadUrl("https://gitlab.com/-/snippets/2533386");break;
            case "Fetch stored data from h2 in-memory database using jpa repository and jdbctemplate":
                webView.loadUrl("https://gitlab.com/PRIYANKA-Nigam/spring-boot-apis/-/snippets/2533380");break;
            case "Implementation of basic GET API":
                webView.loadUrl("https://gitlab.com/-/snippets/2533411");break;
        }

        webView.setWebViewClient(new DownloadAPKZip.client()); WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true); webView.clearCache(true);
        webView.clearHistory();
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
    public void ClickLogout(View view){
        logout(this); }
    public static void logout(final ViewCodeActivity mainActivity) { android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(mainActivity);
        builder.setTitle("Logout");builder.setMessage("Are You Sure You Want to Logout ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)  @Override
            public void onClick(DialogInterface dialog, int which) {
                mainActivity.finishAffinity();System.exit(0); }});
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { @Override
        public void onClick(DialogInterface dialog, int which) { dialog.dismiss(); }}); builder.show(); }
}
