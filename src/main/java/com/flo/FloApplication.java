package com.flo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class FloApplication {

    @RequestMapping(name = "/")
    @ResponseBody
    public String hello(){
        return "Hello";
    }

    public static void main(String[] args) {
        SpringApplication.run(FloApplication.class, args);
    }

}
