package com.flo.ResponseObject;

import java.util.ArrayList;
import java.util.List;

public class AlbumResponse {


    private String title;
    private long id;
    private List<SongResponse> songs;

    public AlbumResponse() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<SongResponse> getSongs() {
        return songs;
    }

    public void addSong(SongResponse songResponse){
        if(this.songs == null){
            this.songs = new ArrayList<>();
        }
        this.songs.add(songResponse);
    }
}
