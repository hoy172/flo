package com.flo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name="length")
    private int length;

    @Column(name="track")
    private int track;

    @Column(name = "album_id")
    private long albumId;

    @ManyToMany(mappedBy = "songs", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<PlayList> playListList = new ArrayList<>();


    public Song() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public List<PlayList> getPlayListList() {
        return playListList;
    }

    public void setPlayListList(List<PlayList> playListList) {
        this.playListList = playListList;
    }
}
