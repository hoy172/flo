package com.flo.Service;

import com.flo.ResponseObject.AlbumResponse;
import com.flo.ResponseObject.SerachResponse;
import com.flo.ResponseObject.SongResponse;
import com.flo.model.Album;
import com.flo.model.Song;
import com.flo.model.songInterface;
import com.flo.repository.AlbumRepository;
import com.flo.repository.SongRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongRepository songRepository;

    @Override
    public SerachResponse search(String title, String locale) {
        List<Album> albums = albumRepository.findByTitleContainsAndLocales_localeNameContains(title,locale);
        List<songInterface> songs = songRepository.searchTitleAndLocale(title,locale);

        SerachResponse serachResponse = new SerachResponse();

        for(Album a: albums){
            AlbumResponse albumResponse = new AlbumResponse();
            albumResponse.setId(a.getId());
            albumResponse.setTitle(a.getTitle());
            for(Song s: a.getSongs()){
                SongResponse sr = new SongResponse();
                sr.setTitle(s.getTitle());
                sr.setId(s.getId());
                sr.setTrack(s.getTrack());
                sr.setLength(s.getLength());
                albumResponse.addSong(sr);
            }
            serachResponse.addAlbums(albumResponse);
        }
        for(songInterface s: songs){
            SongResponse sr2 = new SongResponse();
            sr2.setTitle(s.getTitle());
            sr2.setId(s.getId());
            sr2.setTrack(s.getTrack());
            sr2.setLength(s.getLength());
            serachResponse.addSongs(sr2);
        }
        return serachResponse;
    }

    @Override
    public String getAlbum(String locale, int page) {
        PageRequest pageRequest = new PageRequest(page-1,10);
        Page<Album> contents = albumRepository.findByLocales_localeName(locale, pageRequest);
        Map pageTree = new LinkedHashMap();
        if(!contents.isFirst()){
            pageTree.put("first", "https://SERVER_URL/api/albums?page=1");
            pageTree.put("prev", "https://SERVER_URL/api/albums?page="+(contents.previousPageable().getPageNumber()+1));

        }
        if(!contents.isLast()){
            pageTree.put("last", "https://SERVER_URL/api/albums?page="+contents.getTotalPages());
            pageTree.put("next", "https://SERVER_URL/api/albums?page="+(contents.nextPageable().getPageNumber()+1));
        }
        JSONObject pages = new JSONObject(pageTree);
        Map root  = new LinkedHashMap();
        root.put("satusCode", 200);
        root.put("pages", pages);
        JSONArray albumArray = new JSONArray();
        for(Album a: contents.getContent()){
            Map album = new LinkedHashMap();
            album.put("id", a.getId());
            album.put("title", a.getTitle());

            JSONArray songArray = new JSONArray();
            for(Song s: a.getSongs()){
                Map song = new LinkedHashMap();
                song.put("id",s.getId());
                song.put("title", s.getTitle());
                song.put("track", s.getTrack());
                song.put("length", s.getLength());
                JSONObject sObj = new JSONObject(song);
                songArray.put(sObj);
            }
            album.put("songs",songArray);
            JSONObject aObj = new JSONObject(album);
            albumArray.put(aObj);
        }
        root.put("albums", albumArray);
        JSONObject rootJson = new JSONObject(root);
        return  rootJson.toString();
    }
}
