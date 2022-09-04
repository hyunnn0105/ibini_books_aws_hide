package com.ibini.my_books.post.service;

import com.ibini.my_books.post.domain.LinkPost;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class LinkPostServiceTest {

    @Autowired LinkPostService service;

    @Test
    @DisplayName("링크를 DB에 등록한다")
    void connectTest(){
        LinkPost lp = new LinkPost(45L, 50L);
        boolean flag = service.connectPostService(lp);
        assertTrue(flag);
    }

    @Test
    @DisplayName("중복 링크는 DB에 등록하지 않는다")
    void connectTest2(){
        LinkPost lp = new LinkPost(45L, 50L);
        boolean flag = service.connectPostService(lp);
        assertFalse(flag);
    }

    @Test
    @DisplayName("링크를 DB에서 삭제한다")
    void disconnectTest(){
        String linkId = "45_50";
        boolean flag = service.disconnectPostService(linkId);
        assertTrue(flag);
    }

    @Test
    @DisplayName("루트 포스트 넘버로 연결된 포스트를 조회할 수 있어야 한다")
    void getListTest(){
        Long rootPostNo = 2L;
        Map<String, Object> linkMap = service.getLinkListService(rootPostNo);
        System.out.println("----------------------------- check here");
        for (String s : linkMap.keySet()) {
            System.out.println(s);
            System.out.println(linkMap.get(s));
        }
    }

}