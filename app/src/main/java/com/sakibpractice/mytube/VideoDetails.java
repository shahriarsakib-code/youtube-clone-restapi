package com.sakibpractice.mytube;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;


import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.squareup.picasso.Picasso;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VideoDetails extends AppCompatActivity {

    TextView title,views,cname,subs,subs_textB,likes;
    ImageView cimg,bell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_details);


        title=findViewById(R.id.title_video);
        views=findViewById(R.id.totalviews);
        cname=findViewById(R.id.channelname);
        subs=findViewById(R.id.channelsubs);
        cimg=findViewById(R.id.channel_logo);
        subs_textB=findViewById(R.id.subsnow);
        bell=findViewById(R.id.bell);
        likes=findViewById(R.id.likes);


        // Check for intent and extra
        Intent intent = getIntent();
        String url = intent.getStringExtra("videourl");
        String cnameS = intent.getStringExtra("cname");
        String cpicS= intent.getStringExtra("cpic");
        String totalviewsS = intent.getStringExtra("totalviews");
        String titleS = intent.getStringExtra("title");
       String subscriber = intent.getStringExtra("subscriber");
       String likesS = intent.getStringExtra("likes");


        title.setText(titleS);
        views.setText(totalviewsS);
        cname.setText(cnameS);
        subs.setText(subscriber);
        likes.setText(likesS);

        Picasso.get().load(cpicS).into(cimg);


        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                if (youTubePlayer != null) {


                    // Replace this video ID with the actual YouTube video ID
                    youTubePlayer.loadVideo(url, 0);

                }
            }
        });

        subs_textB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subs_textB.setText("Subscribed");
                bell.setVisibility(View.VISIBLE);
            }
        });

    }


}