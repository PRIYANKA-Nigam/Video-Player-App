package com.example.videoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<Modal> arrayList;
private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

}