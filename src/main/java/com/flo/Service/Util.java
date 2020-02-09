package com.flo.Service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flo.model.Album;
import com.flo.model.Locale;
import com.flo.model.Song;
import com.flo.model.TestData;
import com.flo.repository.AlbumRepository;
import com.flo.repository.LocaleRepository;
import com.flo.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@Component
public class Util {


    @Autowired
    private final AlbumRepository albumRepository;
    @Autowired
    private final LocaleRepository localeRepository;
    @Autowired
    private final SongRepository songRepository;

    public Util(AlbumRepository albumRepository, LocaleRepository localeRepository, SongRepository songRepository) {
        this.albumRepository = albumRepository;
        this.localeRepository = localeRepository;
        this.songRepository = songRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void getJson() throws IOException {


        ObjectMapper mapper = new ObjectMapper();
//        File jsonFile = new File(getClass().getResource("album.json").getFile());
        TestData testData = new TestData();
        JsonNode jsonNode = mapper.readTree(testData.td);
        Iterator iterator = jsonNode.iterator();
        while (iterator.hasNext()){
            JsonNode albumNode = mapper.readTree(iterator.next().toString());
            String albumTitle  = albumNode.get("album_title").asText();
            System.out.println(albumNode);
            System.out.println(albumNode.get("locales"));
            Album album = new Album();
            album.setTitle(albumTitle);

//            JsonNode localeNode = mapper.readTree(albumNode.get("locales").iterator());
            Iterator localeItr = albumNode.get("locales").iterator();
//            System.out.println(localeNode);

            Iterator songItr = albumNode.get("songs").iterator();
            while (songItr.hasNext()){
                JsonNode songNode = mapper.readTree(songItr.next().toString());
                int songLen = songNode.get("length").asInt();
                String songtitle = songNode.get("title").asText();
                int songTrack = songNode.get("track").asInt();

                Song song = new Song();
                song.setLength(songLen);
                song.setTitle(songtitle);
                song.setTrack(songTrack);
                album.addSongs(song);
            }



            while (localeItr.hasNext()){
                String locale = localeItr.next().toString();

                System.out.println("--------------");
                locale = locale.replace("\"", "");
                Locale localeObj = new Locale();
                localeObj.setLocaleName(locale);
                System.out.println(localeObj.getLocaleName());
                System.out.println(locale);
                Locale saveLocale ;
                if (!localeRepository.existsByLocaleName(locale)) {

                    saveLocale = localeRepository.saveAndFlush(localeObj);
                }else{
                    saveLocale = localeRepository.findByLocaleName(locale);
                }
                album.addLocales(saveLocale);




                System.out.println(locale);
                System.out.println("--------------");
            }
            albumRepository.save(album);
        }
    }
}
