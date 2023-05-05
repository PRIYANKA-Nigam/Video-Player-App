package com.example.videoapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class CodeActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;   TableLayout tableLayout;
String[] arr = new String[]{"CV Maker App", "Convertor App", "Calculator App",
            "Monthlies Tracker App", "Inventory Management App", "Novel Scholar App", "Notification App",
            "Greetings App", "Shlok Mantra App", "Quiz App", "Banking App", "ATM Cash Dispenser App",
            "Dictionary App", "Text to Json Convertor App", "PHP Basics","API-1","API-2","API-3","API-4","API-5"};
//        "Storing JSP form data to h2 in-memory database",
//            "Store data to h2 in-memory database using jdbctemplate class",
//            "CRUD operation with postman using ResponseEntity class",
//            "Fetch stored data from h2 in-memory database using jpa repository and jdbctemplate",
//            "Implementation of basic GET API"};
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
    public static void logout(final ZipActivity mainActivity3) {
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
        setContentView(R.layout.activity_code);
        drawerLayout=(DrawerLayout)findViewById(R.id.ddraw);
        tableLayout=findViewById(R.id.tl);

        for(int i=0;i<20;i++){
            TableRow tableRow = new TableRow(this);
            TextView t1 = new TextView(this);
            TextView t2 = new TextView(this);
            t2.setText("VIEW"); t2.setTextColor(getResources().getColor(R.color.white));
            t2.setBackgroundColor(getResources().getColor(R.color.purple_500));
            t1.setText(arr[i]);t1.setTextSize(22); t2.setTextSize(22);t2.setGravity(Gravity.START);
            String s= (String) t1.getText();
            if(i==15) {
                s="Storing JSP form data to h2 in-memory database";
                t1.setTooltipText(s);
            }
            if(i==16) {
                s="Store data to h2 in-memory database using jdbctemplate class";
                t1.setTooltipText(s);
            }
            if(i==17) {
                s="CRUD operation with postman using ResponseEntity class";
                t1.setTooltipText(s);
            }
            if(i==18) {
                s="Fetch stored data from h2 in-memory database using jpa repository and jdbctemplate";
                t1.setTooltipText(s);
            }
            if(i==19) {
                s="Implementation of basic GET API";
                t1.setTooltipText(s);
            }
            String finalS = s;
            t2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(),ViewCodeActivity.class);
                    intent.putExtra("title", finalS);
                    startActivity(intent);
                }
            });
            tableRow.addView(t1);
            tableRow.addView(t2);
            TableRow tableRow2 = new TableRow(this);
            TextView t3 = new TextView(this);
            TextView t4 = new TextView(this);
            t3.setText(" ");t4.setText(" ");
            tableRow2.addView(t3); tableRow2.addView(t4);
            tableLayout.addView(tableRow);
            tableLayout.addView(tableRow2);
        }

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
    public void ClickZip(View view){ MainActivity.redirectActivity(this,ZipActivity.class);
    }
    public void ClickCode(View view){
        recreate();
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