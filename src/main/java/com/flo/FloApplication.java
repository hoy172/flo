package com.flo;


import com.flo.Service.Util;
import com.flo.repository.AlbumRepository;
import com.flo.repository.LocaleRepository;
import com.flo.repository.SongRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@SpringBootApplication
@Configurable
public class FloApplication {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    LocaleRepository localeRepository;

    @Autowired
    SongRepository songRepository;

    @Autowired
    private static Util util;

    @RequestMapping("/")
    @ResponseBody
    public String hello() throws IOException {
        return "Hello";
    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(FloApplication.class, args);

    }

    public void run(){
        util = new Util(this.albumRepository,this.localeRepository,this.songRepository);

    }

}
