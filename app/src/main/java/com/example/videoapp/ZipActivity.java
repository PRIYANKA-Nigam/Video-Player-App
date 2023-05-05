package com.example.videoapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class ZipActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;  static int flag;
    RecyclerView recyclerView;
    ArrayList<APK_ZIP_Modal> mainModels;
    APK_Adapter mainAdapter;
    public static void logout(final MainActivity mainActivity2) {
        AlertDialog.Builder builder=new AlertDialog.Builder(mainActivity2);builder.setTitle("Logout");
        builder.setMessage("Are You Sure You Want to Logout ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)  @Override
            public void onClick(DialogInterface dialog, int which) {
                mainActivity2.finishAffinity(); System.exit(0); }});
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); }});builder.show(); }
    public static void logout(final APKActivity ai) {
        AlertDialog.Builder builder=new AlertDialog.Builder(ai);builder.setTitle("Logout");
        builder.setMessage("Are You Sure You Want to Logout ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)  @Override
            public void onClick(DialogInterface dialog, int which) {
                ai.finishAffinity(); System.exit(0); }});
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss(); }});builder.show(); }
    public static void logout(final CodeActivity mainActivity3) {
        AlertDialog.Builder builder=new AlertDialog.Builder(mainActivity3);builder.setTitle("Logout");
        builder.setMessage("Are You Sure You Want to Logout ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)  @Override
            public void onClick(DialogInterface dialog, int which) {
                mainActivity3.finishAffinity(); System.exit(0); }});
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); }});builder.show(); }
    public static void logout(final AboutActivity mainActivity2) {
        AlertDialog.Builder builder=new AlertDialog.Builder(mainActivity2);builder.setTitle("Logout");
        builder.setMessage("Are You Sure You Want to Logout ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)  @Override
            public void onClick(DialogInterface dialog, int which) {
                mainActivity2.finishAffinity(); System.exit(0); }});
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss(); }});builder.show(); }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zip);
        drawerLayout=(DrawerLayout)findViewById(R.id.cdraw);
        flag=2;
        recyclerView=(RecyclerView)findViewById(R.id.rec);
        mainModels=new ArrayList<>();
        mainAdapter =new APK_Adapter(this,mainModels);
        String[] title={ "Convertor App","Inventory Management App","Novel Scholar App",
                "Notification App","Greetings App",
                "Shlok Mantra App","Quiz App"};
        for(int i=0;i<title.length;i++){
            APK_ZIP_Modal mainModel=new APK_ZIP_Modal(title[i]);
            this.mainModels.add(mainModel);
        }
        RecyclerView.LayoutManager layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mainAdapter=new APK_Adapter(ZipActivity.this,mainModels);
        recyclerView.setAdapter(mainAdapter);
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
    public void ClickAPK(View view){ MainActivity.redirectActivity(this,APKActivity.class);
    }
    public void ClickZip(View view){
        recreate();
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
    public void ClickLogout(View view){ MainActivity.logout(this); }

    @Override
    protected void onPause() { super.onPause(); closeDrawer(drawerLayout); }
}