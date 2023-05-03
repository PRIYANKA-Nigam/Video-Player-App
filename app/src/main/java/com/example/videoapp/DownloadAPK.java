package com.example.videoapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class DownloadAPK extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_a_p_k);
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

    public void callDialog(String s) {
        AlertDialog.Builder builder = new AlertDialog.Builder(DownloadAPK.this);
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
}