package com.example.videoapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.pd.lookatme.LookAtMe;

public class Ai_Mode_Activity extends AppCompatActivity {
    ToggleButton toggleButton;
    DrawerLayout drawerLayout;
    private LookAtMe lookAtMe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ai__mode_);
        drawerLayout=(DrawerLayout)findViewById(R.id.draw);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_USER);
        toggleButton = findViewById(R.id.tb1);
        toggleButton.setTooltipText("Switch to Normal Mode");
        String title=getIntent().getStringExtra("title");
        Toast.makeText(getApplicationContext(),"Title: "+title,Toast.LENGTH_SHORT).show();
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                onBackPressed(); or
                finish();
            }
        });
        lookAtMe = findViewById(R.id.lookme);
        lookAtMe.init(this);
        switch (title){
            case "CV Maker App":
                lookAtMe.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.cv_maker));break;
            case "Convertor App":
                lookAtMe.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.convertor));break;
            case "Calculator App":
                lookAtMe.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.calculator));break;
            case "Monthlies Tracker App":
                lookAtMe.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.monthlies_tracker));break;
            case "Inventory Management App":
                lookAtMe.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.inventory));break;
            case "Novel Scholar App":
                lookAtMe.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.novel));break;
            case "Notification App":
                lookAtMe.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.notification));break;
            case "Greetings App":
                lookAtMe.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.greetings));break;
            case "Shlok Mantra App":
                lookAtMe.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.shlok));break;
            case "Quiz App":
                lookAtMe.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.quiz));break;
            case "Banking App":
            lookAtMe.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.banking_app));break;
            case "ATM Cash Dispenser App":
            lookAtMe.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.atm_cash_dispenser));break;
            case "Dictionary App":
                lookAtMe.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.dictionary));break;
            case "Text to Json Convertor App":
                lookAtMe.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.text_to_json_convertor));break;
            case "PHP Basics":
                lookAtMe.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.php_basics));break;
            case "Storing JSP form data to h2 in-memory database":
                lookAtMe.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.jsp_jpa_h2));break;
            case "Store data to h2 in-memory database using jdbctemplate class":
                lookAtMe.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.jdbctemplate));break;
            case "CRUD operation with postman using ResponseEntity class":
                lookAtMe.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.post_get_api_with_response_entity));break;
            case "Fetch stored data from h2 in-memory database using jpa repository and jdbctemplate":
                lookAtMe.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.see_stored_data_jpa_jdbc));break;
            case "Implementation of basic GET API":
                lookAtMe.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.get_api_response));break;
        }
        lookAtMe.start();
        lookAtMe.setLookMe();
        getSupportActionBar().hide();
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
    public static void logout(final Ai_Mode_Activity mainActivity) { android.app.AlertDialog.Builder builder=new android.app.AlertDialog.Builder(mainActivity);
        builder.setTitle("Logout");builder.setMessage("Are You Sure You Want to Logout ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)  @Override
            public void onClick(DialogInterface dialog, int which) {
                mainActivity.finishAffinity();System.exit(0); }});
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { @Override
        public void onClick(DialogInterface dialog, int which) { dialog.dismiss(); }}); builder.show(); }
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig); //to continue play video from that point in landscape mode
    }

}