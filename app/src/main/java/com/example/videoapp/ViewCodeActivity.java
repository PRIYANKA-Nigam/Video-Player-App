package com.example.videoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class ViewCodeActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_code);
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

        webView.setWebViewClient(new DownloadAPK.client()); WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true); webView.clearCache(true);
        webView.clearHistory();
    }

}
