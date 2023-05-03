package com.example.videoapp;

public class Modal {
String video;
String title;

    public Modal(String video, String title) {
        this.video = video;
        this.title = title;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
