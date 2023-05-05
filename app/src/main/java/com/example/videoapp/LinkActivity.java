package com.example.videoapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class LinkActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link);
        drawerLayout=(DrawerLayout)findViewById(R.id.draw);
        textView = findViewById(R.id.textView2);
       textView.setMovementMethod(LinkMovementMethod.getInstance()); //to make link clickable --
        String link = getIntent().getStringExtra("link");
        String spackage = "com.example.videoapp";
        String webLink = "";
        openLink(link, spackage, webLink);
    }
    private void openLink(String appLink, String spackage, String webLink) {
        try {
            Uri uri = Uri.parse(appLink);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (ActivityNotFoundException activityNotFoundException) {
            Uri uri = Uri.parse(webLink);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
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
    public static void logout(final LinkActivity mainActivity) { android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(mainActivity);
        builder.setTitle("Logout");builder.setMessage("Are You Sure You Want to Logout ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)  @Override
            public void onClick(DialogInterface dialog, int which) {
                mainActivity.finishAffinity();System.exit(0); }});
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { @Override
        public void onClick(DialogInterface dialog, int which) { dialog.dismiss(); }}); builder.show(); }
}