package com.flo.Service;

import com.flo.model.Album;
import com.flo.model.PlayList;
import com.flo.model.Song;
import com.flo.repository.AlbumRepository;
import com.flo.repository.PlayListRepository;
import com.flo.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayListServiceImpl implements PlayListService {

    @Autowired
    PlayListRepository playListRepository;

    @Autowired
    SongRepository songRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Override
    public Boolean addSong(long id, boolean isAlbum, long playListId) {
        PlayList playList = playListRepository.findById(playListId).orElse(null);

        if(playList==null){
            return false;
        }
        System.out.println( isAlbum);

        if(isAlbum){
            Album album = albumRepository.findById(id).orElse(null);
            for(Song s: album.getSongs()){
                playList.addSongs(s);
            }
        }else{
            Song song = songRepository.findById(id).orElse(null);
            playList.addSongs(song);
        }
        playListRepository.save(playList);
        return true;
    }

    @Override
    public Boolean makePlayList(int userId, String title) {

        PlayList playList = new PlayList();
        playList.setUserId(userId);
        playList.setTitle(title);
        PlayList createdPl = playListRepository.save(playList);
        if(createdPl == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public List<PlayList> getplayList(int userId) {
        return playListRepository.findAllByUserId(userId);
    }

    @Override
    public Boolean delete(long id) {
       PlayList playList = playListRepository.findById(id).orElse(null);
       if(playList == null){
           return false;
       }else{
           playListRepository.delete(playList);
           return true;
       }
    }
}
