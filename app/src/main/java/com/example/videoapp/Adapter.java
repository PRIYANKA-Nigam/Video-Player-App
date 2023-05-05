package com.example.videoapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Locale;

public class Adapter extends RecyclerView.Adapter<viewHolder> {
    private Context context;
     private  viewHolder viewHolder;
    public Adapter(Context context, ArrayList<Modal> videoArrayList) {
        this.context = context;
        this.videoArrayList = videoArrayList;
    }

    private ArrayList<Modal> videoArrayList;

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        WebResourceRequest request = null;
        final Modal modal = videoArrayList.get(position);
//       holder.webView.loadUrl(modal.getVideo());
        final String[] s = new String[1];
        holder.webView.loadData(modal.getVideo(),"text/html","utf-8");
        holder.webView. setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon){
                super.onPageStarted(view, url, favicon);
             s[0] =view.getUrl();
                Log.e("URL", url);
            }
        });

       holder.title.setText(modal.getTitle());
       holder.cardView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(context,MainActivity2.class);
               intent.putExtra("link", s[0]);
               intent.putExtra("title", modal.getTitle());
               context.startActivity(intent);
           }
       });
       holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
           @Override
           public boolean onLongClick(View view) {
               PopupMenu popup = new PopupMenu(context, holder.cardView);
               popup.inflate(R.menu.options_menu);

               popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                   @Override
                   public boolean onMenuItemClick(MenuItem item) {
                       switch (item.getItemId()) {
                           case R.id.share: {
                               Intent intent = new Intent(Intent.ACTION_SEND);
                               intent.setType("text/plain");
                               intent.putExtra(Intent.EXTRA_TEXT, s[0]);
                               context.startActivity(Intent.createChooser(intent, null));
                           }
                               break;
                           case R.id.download:
                           {
                               Intent intent = new Intent(context, DownloadAPKZip.class);
                               intent.putExtra("title", modal.getTitle());
                               context.startActivity(intent);
                           }
                               break;
                           case R.id.view:
                               Intent intent = new Intent(context,ViewCodeActivity.class);
                               intent.putExtra("title", modal.getTitle());
                               context.startActivity(intent);
                               break;
                       }
                       return false;
                   }
               });
               //displaying the popup
               popup.show();
              return false;
           }
       });
    }

    @Override
    public int getItemCount() {
        return videoArrayList.size();
    }

    public void setFilter(ArrayList<Modal> newList){
        videoArrayList=new ArrayList<>();
        videoArrayList.addAll(newList);
        notifyDataSetChanged(); }

}
class viewHolder extends RecyclerView.ViewHolder  {
    WebView webView; CardView cardView;
    TextView title;


    public viewHolder(View convertView) {
        super(convertView);
        webView=convertView.findViewById(R.id.visible);
        cardView= convertView.findViewById(R.id.cd);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);
        title= (TextView)convertView.findViewById(R.id.text);


    }


}