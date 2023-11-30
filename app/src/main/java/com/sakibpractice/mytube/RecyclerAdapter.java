package com.sakibpractice.mytube;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.squareup.picasso.Callback;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<VideoViewHolder> {

    List<VideosItem> lists;
    Context context;

    public RecyclerAdapter(List<VideosItem> lists, Context context) {
        this.lists = lists;
        this.context = context;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_single_item,parent,false);
        VideoViewHolder viewHolder = new VideoViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {

        final VideosItem myitem = lists.get(position);
        holder.titletext.setText(myitem.getTitle());
        holder.cnametext.setText(myitem.getCname());
        holder.viewstext.setText(myitem.getTotalviews());
        holder.datetext.setText(myitem.getUploadtime());
        holder.time.setText(myitem.getTime());

        Picasso.get()
                .load(myitem.getThumbnail())
                .placeholder(R.drawable.placeholder) // Replace with your placeholder image
                .into(holder.thumbnailimg);
        
        Picasso.get().load(myitem.getCpic()).into(holder.channelicon);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(v.getContext(),VideoDetails.class);
                intent.putExtra("title",myitem.getTitle());
                intent.putExtra("description",myitem.getDescription());
                intent.putExtra("subscriber",myitem.getSubscriber());
                intent.putExtra("cname",myitem.getCname());
                intent.putExtra("cpic",myitem.getCpic());
                intent.putExtra("uploadtime",myitem.getUploadtime());
                intent.putExtra("totalviews",myitem.getTotalviews());
               // intent.putExtra("subscriber",myitem.get);
                intent.putExtra("videourl",myitem.getVideourl());
                intent.putExtra("time",myitem.getTime());
                intent.putExtra("likes",myitem.getLikes());
                v.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return lists.size();
    }
}
