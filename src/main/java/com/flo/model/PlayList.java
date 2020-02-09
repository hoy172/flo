package com.flo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PlayList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "user_id")
    private int userId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Playlist_Song")
    @JsonManagedReference
    private List<Song> songs;

    @Column
    private String title;

    public PlayList() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void addSongs(Song song){
        if(this.songs == null){
            this.songs = new ArrayList<>();
        }
        this.songs.add(song);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
