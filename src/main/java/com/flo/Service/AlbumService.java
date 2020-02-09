package com.flo.Service;

import com.flo.ResponseObject.SerachResponse;

public interface AlbumService {

    SerachResponse search(String title, String locale);
    String getAlbum(String locale, int page);

}
