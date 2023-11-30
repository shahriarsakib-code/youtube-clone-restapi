package com.sakibpractice.mytube;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VideoViewHolder extends RecyclerView.ViewHolder {

    TextView titletext,cnametext,viewstext,datetext,time;
    ImageView thumbnailimg,channelicon;
    public VideoViewHolder(@NonNull View itemView) {

        super(itemView);
        thumbnailimg = itemView.findViewById(R.id.thumbnail);
        titletext=itemView.findViewById(R.id.textView);
        cnametext=itemView.findViewById(R.id.channelname);
        viewstext=itemView.findViewById(R.id.viewstext);
        datetext=itemView.findViewById(R.id.datetext);
        channelicon=itemView.findViewById(R.id.channelicon);
        time=itemView.findViewById(R.id.time);
    }
}
