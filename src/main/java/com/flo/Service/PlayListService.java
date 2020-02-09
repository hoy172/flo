package com.flo.Service;

import com.flo.model.PlayList;
import com.flo.repository.PlayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayListService {

    Boolean addSong(long id, boolean isAlbum, long playListId);
    Boolean makePlayList(int userId, String title);
    List<PlayList> getplayList(int userId);
    Boolean delete(long id);
}
