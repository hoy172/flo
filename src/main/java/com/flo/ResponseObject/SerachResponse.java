package com.flo.ResponseObject;

import java.util.ArrayList;
import java.util.List;

public class SerachResponse {

    private List<AlbumResponse> albums;
    private List<SongResponse> songs;

    public SerachResponse() {
    }

    public List<AlbumResponse> getAlbums() {
        return albums;
    }

    public void addAlbums(AlbumResponse albumResponse){
        if(this.albums == null){
            this.albums = new ArrayList<>();
        }
        this.albums.add(albumResponse);
    }

    public List<SongResponse> getSongs() {
        return songs;
    }
    public void addSongs(SongResponse songResponse){
        if(this.songs == null){
            this.songs = new ArrayList<>();
        }
        this.songs.add(songResponse);
    }


}
