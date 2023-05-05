package com.example.videoapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PictureInPictureParams;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
RecyclerView recyclerView;
ArrayList<Modal> arrayList;
private Adapter adapter;
    DrawerLayout drawerLayout;
    public static void logout(final APKActivity mainActivity2) {
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
    public static void logout(final ZipActivity ai) {
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
        setContentView(R.layout.activity_main);
        drawerLayout=(DrawerLayout)findViewById(R.id.adraw);

        recyclerView=findViewById(R.id.rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        arrayList = new ArrayList<>();
        arrayList.add(new Modal("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/56Yz9d-8MA8\" " +
                "frameborder=\"0\" allowfullscreen></iframe>","CV Maker App"));
        arrayList.add(new Modal("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/hUzQaBnpq6g\" " +
                "frameborder=\"0\" allowfullscreen></iframe>","Convertor App"));
        arrayList.add(new Modal("<iframe width=\"100%\" height=\"100%\" src=\" https://www.youtube.com/embed/3KaQ8wPcU3s\" " +
                "frameborder=\"0\" allowfullscreen></iframe>","Calculator App"));
        arrayList.add(new Modal("<iframe width=\"100%\" height=\"100%\" src=\" https://www.youtube.com/embed/ZtlI2tFGpJY\" " +
                "frameborder=\\\"0\\\" allowfullscreen></iframe>","Monthlies Tracker App"));
        arrayList.add(new Modal("<iframe width=\"100%\" height=\"100%\" src=\" https://www.youtube.com/embed/1cMxb8yDogQ\" " +
                "frameborder=\\\"0\\\" allowfullscreen></iframe>","Inventory Management App"));
        arrayList.add(new Modal("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/_DgbxCmFp7U\" " +
                "frameborder=\"0\" allowfullscreen></iframe>","Novel Scholar App"));
        arrayList.add(new Modal("<iframe width=\"100%\" height=\"100%\" src=\" https://www.youtube.com/embed/i4PaRDoWrTw\" " +
                "frameborder=\"0\" allowfullscreen></iframe>","Notification App "));
        arrayList.add(new Modal("<iframe width=\"100%\" height=\"100%\" src=\" https://www.youtube.com/embed/pzJSihm2bI8\" " +
                "frameborder=\\\"0\\\" allowfullscreen></iframe>","Greetings App "));
        arrayList.add(new Modal("<iframe width=\"100%\" height=\"100%\" src=\" https://www.youtube.com/embed/BLhL3ssK8jw\" " +
                "frameborder=\\\"0\\\" allowfullscreen></iframe>","Shlok Mantra App "));
        arrayList.add(new Modal("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/UFC2ekIkQnk\" " +
                "frameborder=\"0\" allowfullscreen></iframe>","Quiz App"));
        arrayList.add(new Modal("<iframe width=\"100%\" height=\"100%\" src=\" https://www.youtube.com/embed/CyPm6bI38rY\" " +
                "frameborder=\"0\" allowfullscreen></iframe>","Banking App"));
        arrayList.add(new Modal("<iframe width=\"100%\" height=\"100%\" src=\" https://www.youtube.com/embed/CuKS3A_6S2c\" " +
                "frameborder=\\\"0\\\" allowfullscreen></iframe>","ATM Cash Dispenser App"));
        arrayList.add(new Modal("<iframe width=\"100%\" height=\"100%\" src=\" https://www.youtube.com/embed/WEhD-InloNU\" " +
                "frameborder=\\\"0\\\" allowfullscreen></iframe>","Dictionary App"));
        arrayList.add(new Modal("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/CbSQLdG7SAM\n\" " +
                "frameborder=\"0\" allowfullscreen></iframe>","Text to Json Convertor App"));
        arrayList.add(new Modal("<iframe width=\"100%\" height=\"100%\" src=\" https://www.youtube.com/embed/xBh94I8BFS4\" " +
                "frameborder=\"0\" allowfullscreen></iframe>","PHP Basics"));
        arrayList.add(new Modal("<iframe width=\"100%\" height=\"100%\" src=\" https://www.youtube.com/embed/9etRXwV_otg\" " +
                "frameborder=\\\"0\\\" allowfullscreen></iframe>","Storing JSP form data to h2 in-memory database"));
        arrayList.add(new Modal("<iframe width=\"100%\" height=\"100%\" src=\" https://www.youtube.com/embed/q5BH5XV9RxA\" " +
                "frameborder=\\\"0\\\" allowfullscreen></iframe>","Store data to h2 in-memory database using jdbctemplate class"));
        arrayList.add(new Modal("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/22FfQoqDtVA\" " +
                "frameborder=\"0\" allowfullscreen></iframe>","CRUD operation with postman using ResponseEntity class"));
        arrayList.add(new Modal("<iframe width=\"100%\" height=\"100%\" src=\" https://www.youtube.com/embed/_a_IFsXQLPs\" " +
                "frameborder=\"0\" allowfullscreen></iframe>","Fetch stored data from h2 in-memory database using jpa repository and jdbctemplate"));
        arrayList.add(new Modal("<iframe width=\"100%\" height=\"100%\" src=\" https://www.youtube.com/embed/UCWMSNbXlu8\" " +
                "frameborder=\\\"0\\\" allowfullscreen></iframe>","Implementation of basic GET API"));

        adapter = new Adapter(this,arrayList);
        recyclerView.setAdapter(adapter);

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
        recreate();
    }
    public void ClickAPK(View view){
        redirectActivity(this,APKActivity.class);
    }
    public void ClickZip(View view){
        redirectActivity(this,ZipActivity.class);
    }
    public void ClickCode(View view){
        redirectActivity(this,CodeActivity.class);
    }
    public void ClickAboutUs(View view){
        redirectActivity(this,AboutActivity.class);
    }
    public void ClickLinkedIn(View view){redirectActivity2(this,LinkActivity.class,"l");}
    public void ClickInsta(View view){redirectActivity2(this,LinkActivity.class,"i");}
    public void ClickTwitter(View view){redirectActivity2(this,LinkActivity.class,"t");}
    public void ClickFB(View view){redirectActivity2(this,LinkActivity.class,"f");}
    public void ClickWebsite(View view){redirectActivity2(this,LinkActivity.class,"w");}
    public void ClickGithub(View view){redirectActivity2(this,LinkActivity.class,"g");}
    public void ClickGitlab(View view){redirectActivity2(this,LinkActivity.class,"gi");}
    public void ClickHack(View view){redirectActivity2(this,LinkActivity.class,"h");}
    public void ClickLogout(View view){
        logout(this); }
    public static void logout(final MainActivity mainActivity) { AlertDialog.Builder builder=new AlertDialog.Builder(mainActivity);
        builder.setTitle("Logout");builder.setMessage("Are You Sure You Want to Logout ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)  @Override
            public void onClick(DialogInterface dialog, int which) {
                mainActivity.finishAffinity();System.exit(0); }});
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { @Override
        public void onClick(DialogInterface dialog, int which) { dialog.dismiss(); }}); builder.show(); }
    public static void redirectActivity2(Activity activity, Class aclass,String s) { Intent intent=new Intent(activity,aclass);
    if(s=="l")
        intent.putExtra("link","https://www.linkedin.com/in/priyanka-nigam-083247172");
        if(s=="i")
            intent.putExtra("link","https://www.instagram.com/nigampriyanka042");
        if(s=="t")
            intent.putExtra("link","https://www.twitter.com/PriyankaN2504");
        if(s=="f")
            intent.putExtra("link","https://www.facebook.com/priyanka.nigam.9256");
        if(s=="w")
            intent.putExtra("link","https://get2logics.com/");
        if(s=="g")
            intent.putExtra("link","https://github.com/PRIYANKA-Nigam/");
        if(s=="gi")
            intent.putExtra("link","https://gitlab.com/PRIYANKA-Nigam/");
        if(s=="h")
            intent.putExtra("link","https://www.hackerrank.com/ec_1634831038");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); activity.startActivity(intent); }
    public static void redirectActivity(Activity activity, Class aclass) { Intent intent=new Intent(activity,aclass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); activity.startActivity(intent); } @Override
protected void onPause() { super.onPause(); closeDrawer(drawerLayout); }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_dark_brightness,menu);
        MenuItem menuItem=menu.findItem(R.id.see);
        SearchView searchView=(SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
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

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        s=s.toLowerCase();
        ArrayList<Modal> newList=new ArrayList<>();
        for (Modal dish : arrayList){ String name=dish.getTitle().toLowerCase();
            if (name.contains(s))
                newList.add(dish);
        }
        adapter.setFilter(newList);
        return true;

    }
    @Override
    protected void onUserLeaveHint() {
        PictureInPictureParams pictureInPictureParams= new PictureInPictureParams.Builder().build();
        enterPictureInPictureMode(pictureInPictureParams);
    }
}
