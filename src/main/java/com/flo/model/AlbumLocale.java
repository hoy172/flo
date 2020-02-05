package com.flo.model;

import javax.persistence.*;

@Entity
public class AlbumLocale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "Album_id")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "Locale_id")
    private Locale locale;

}


