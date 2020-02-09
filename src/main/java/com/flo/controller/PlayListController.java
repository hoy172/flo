package com.flo.controller;

import com.flo.Service.PlayListService;
import com.flo.model.Album;
import com.flo.model.PlayList;
import com.flo.model.Song;
import com.flo.repository.AlbumRepository;
import com.flo.repository.PlayListRepository;
import com.flo.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/playlist")
public class PlayListController {

    @Autowired
    PlayListService playListService;

    @RequestMapping(value = "/make", method = RequestMethod.POST)
    public ResponseEntity<Void> makePlayList(int userId ,  String title){

        boolean result = playListService.makePlayList(userId, title);

        if(result){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Void> addPlayList(long songId,boolean isAlbum,  long playListId){

        boolean result = playListService.addSong(songId,isAlbum,playListId);
        if(result){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // 사용자의 플레이 리스트 목록을 조회
    @RequestMapping(value = "/get/{uid}", method = RequestMethod.GET)
    public ResponseEntity<List<PlayList>> getUserPlayList(@PathVariable("uid") final int id){
        System.out.println(id);
        List<PlayList> playLists = playListService.getplayList(id);
        return new ResponseEntity<List<PlayList>>(playLists, HttpStatus.OK);
    }
    //사용자의 플레이 리스트 삭제
    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePlayList(@PathVariable("id") long id){
        boolean result = playListService.delete(id);
        if(result){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
}
