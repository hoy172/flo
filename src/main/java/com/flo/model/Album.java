package com.flo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String title;

    @OneToMany
    private Collection<Song> Songs  = new ArrayList<>();

    @OneToMany
    private Collection<Locale> Locales = new ArrayList<>();

    @OneToMany(mappedBy = "album")
    private Collection<AlbumLocale> albumLocales = new ArrayList<>();

    public Album() {
    }
}
