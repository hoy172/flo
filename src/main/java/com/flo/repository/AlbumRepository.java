package com.flo.repository;

import com.flo.model.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long> {

    List<Album> findByTitleContainsAndLocales_localeNameContains(String title, String locale);
    Page<Album> findByLocales_localeName(String locale, Pageable pageable);
}
