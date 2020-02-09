package com.flo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.flo.ResponseObject.SerachResponse;
import com.flo.Service.AlbumServiceImpl;
import com.flo.model.Album;
import com.flo.repository.AlbumRepository;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class AlbumController {

    @Autowired
    AlbumServiceImpl albumService;

    @Autowired
    private AlbumRepository albumRepository;

    @RequestMapping(value = "/")
    public void test(){
    }

    @RequestMapping(value = "/all")
    public List<Album> getAll(){
        return albumRepository.findAll();
    }
    /**
     *
     * @param title  검색어
     * @param locale 검색을 요청하는 사용자의 지역
     * @return
     * @Description
     *   문자열로 앨범/곡을 검색해서 제목이 검색어를 포함하는 앨범과 곡을 찾는 API
     *   공백이나 특수문자를 폼함하여 입력한 검색어를 그대로 포함
     *   사용자의 지역에 따라 검색된 결과를 보여준다
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public SerachResponse search(@RequestParam(name = "title") String title, @RequestParam(name = "locale") String locale){

        return albumService.search(title,locale);
    }

    /**
     *
     * @param locale 검색을 요청하는 사용자의 지역
     * @param page 요청할 page
     * @return
     *   앨범을 10개단위로 paging 해서 return 하는 API
     */
    @RequestMapping(value = "/albums", method = RequestMethod.GET)
    public String getAlbum(@RequestParam(name = "locale") String locale, @RequestParam(name = "page") int page) throws JsonProcessingException, JSONException {
        return albumService.getAlbum(locale, page);
    }

}
