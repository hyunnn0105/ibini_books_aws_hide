package com.ibini.my_books;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/post")
public class PlatfromTestController {

    @GetMapping("/write")
    public String getTest(){

        return "hj-test";
    }
}