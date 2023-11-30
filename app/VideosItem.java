public class VideosItem {

    String title,description,cicon,cname,views,thumbnail,date;

    public VideosItem(String title, String description, String cicon, String cname, String views, String thumbnail, String date) {
        this.title = title;
        this.description = description;
        this.cicon = cicon;
        this.cname = cname;
        this.views = views;
        this.thumbnail = thumbnail;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCicon() {
        return cicon;
    }

    public String getCname() {
        return cname;
    }

    public String getViews() {
        return views;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getDate() {
        return date;
    }
}
