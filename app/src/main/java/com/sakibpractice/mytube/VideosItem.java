package com.sakibpractice.mytube;

public class VideosItem {

    private String title;
    private String description;
    private String thumbnail;
    private String cname;
    private String cpic;
    private String uploadtime;
    private String totalviews;
    private String subscriber;
    private String videourl;
    private String time;
    private String likes;

    public VideosItem(String title, String description, String thumbnail, String cname, String cpic, String uploadtime, String totalviews, String subscriber, String videourl, String time,String likes) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.cname = cname;
        this.cpic = cpic;
        this.uploadtime = uploadtime;
        this.totalviews = totalviews;
        this.subscriber = subscriber;
        this.videourl = videourl;
        this.time= time;
        this.likes=likes;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getCname() {
        return cname;
    }

    public String getCpic() {
        return cpic;
    }

    public String getUploadtime() {
        return uploadtime;
    }

    public String getTotalviews() {
        return totalviews;
    }

    public String getSubscriber() {
        return subscriber;
    }

    public String getVideourl() {
        return videourl;
    }

    public String getTime() {
        return time;
    }

    public String getLikes() {
        return likes;
    }
}

