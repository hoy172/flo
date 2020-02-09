package com.flo.repository;

import com.flo.model.Song;
import com.flo.model.songInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    @Query( value = "SELECT            " +
            "   S.title, S.id, S.track, S.length                     " +
            "FROM                      " +
            "   song S                 " +
            "LEFT OUTER JOIN           " +
            "   album A                " +
            "ON                        " +
            "  S.album_id=A.album_id   " +
            "LEFT OUTER JOIN           " +
            " album_locale AL          " +
            "ON                        " +
            "   A.album_id=AL.album_id " +
            "LEFT OUTER JOIN           " +
            "   locale L               " +
            "ON                        " +
            "   AL.locale_id=L.locale_id  " +
            "WHERE                     " +
            " S.title LIKE %:title%        " +
            "AND                       " +
            " L.locale_name=:locale         ",
            nativeQuery = true
    )
    List<songInterface> searchTitleAndLocale(@Param("title") String title, @Param("locale") String locale);
}

