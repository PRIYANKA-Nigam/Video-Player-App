package com.example.videoapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class APK_Adapter extends RecyclerView.Adapter<APK_Adapter.ViewHolder>{
    Context context; ArrayList<APK_ZIP_Modal> mainModels;

    public APK_Adapter(Context context, ArrayList<APK_ZIP_Modal> mainModels) {
        this.context = context;
        this.mainModels = mainModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.apk_row, parent, false);
        if(APKActivity.flag==1) {
         view = LayoutInflater.from(parent.getContext()).inflate(R.layout.apk_row, parent, false);
        }
        if (ZipActivity.flag==2) {
          view = LayoutInflater.from(parent.getContext()).inflate(R.layout.zip_row, parent, false);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     holder.textView.setText(mainModels.get(position).getTitle());
     holder.button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             if(APKActivity.flag==1) {
                 Intent intent = new Intent(context, Download_APK.class);
                 intent.putExtra("title", mainModels.get(position).getTitle());
                 context.startActivity(intent);
             }
             if(ZipActivity.flag==2){
                 Intent intent = new Intent(context, Download_Zip.class);
                 intent.putExtra("title", mainModels.get(position).getTitle());
                 context.startActivity(intent);
             }
         }
     });
    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
      Button button;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           button=itemView.findViewById(R.id.button2);
            textView=itemView.findViewById(R.id.textView);

        }
    }
}
