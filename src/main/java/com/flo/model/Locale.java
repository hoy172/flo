package com.flo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Locale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String localeName;

    @OneToMany(mappedBy = "locale")
    private Collection<AlbumLocale> albumLocales = new ArrayList<>();


}
