package com.flo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Album {

    @Id
    @Column(name = "Album_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String title;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "album_id")
    private List<Song> songs;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Album_Locale",
            joinColumns = @JoinColumn(name = "Album_id"),
            inverseJoinColumns = @JoinColumn(name = "Locale_id")
    )
    @JsonManagedReference
    private List<Locale> locales = new ArrayList<>();


    public Album() {
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

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
    public void addSongs(Song song){
        if(this.songs == null){
            this.songs = new ArrayList<>();
        }
        this.songs.add(song);
    }

    public List<Locale> getLocales() {
        return locales;
    }

    public void setLocales(List<Locale> locales) {
        this.locales = locales;
    }

    public void addLocales(Locale locale){
        if(this.locales == null){
            this.locales = new ArrayList<>();
        }
        this.locales.add(locale);
    }
}
