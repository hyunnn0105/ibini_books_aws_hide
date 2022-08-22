package com.ibini.my_books.post.controller;


import com.ibini.my_books.hashtag.service.HashTagService;
import com.ibini.my_books.post.domain.Post;
import com.ibini.my_books.post.service.PostService;
import com.ibini.my_books.postImg.domain.PostImg;
import com.ibini.my_books.postImg.service.PostImgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {


    private final PostImgService imgService;
    private final PostService postService;
    private final HashTagService hashTagService;

    /*
        포스트 등록 폼 요청   get    /post/write
        포스트 등록 요청      post   /post/write
        포스트 수정 폼 요청   get    /post/modify
        포스트 수정 요청      post   /post/modify
        포스트 삭제 폼 요청  get    /post/delete
        포스트 삭제 요청  post    /post/delete
        포스트 상세 조회 요청  get   /post/detail
     */



    //    포스트 등록 폼 요청   get    /post/write
    @GetMapping("/write")
    public String postWriteForm() {
        log.info("PostController /post/write  GET 요청!!");

        return "post/post-reg";
    }


    //    포스트 등록 요청      post   /post/write
    @PostMapping("/write")
    public String postWrite(Post post, PostImg postImg) {
        log.info("PostController /post/write POST 요청!! - {}", post);

        // tbl_post 저장
        boolean postFlag = postService.saveService(post);

        // prj_post_img 저장

//        imgService.add(postImgList);

        log.info("save flag : {}", postFlag);

        return "redirect:/list";
    }

//    포스트 수정 폼 요청   get    /post/modify
    @GetMapping("/modify")
    public String modify(@ModelAttribute("postNo") Long postNo, Model model){
        log.info("PostController /post/modify  GET 요청!! - {}", postNo);

        return "post/post-modify";
    }

//    포스트 수정 요청      post   /post/modify
    @PostMapping("/modify")
    public String modify(Post post){
        log.info("PostController /post/modify  POST 요청!! - {}", post);

        return "redirect:/list";
    }

    // 포스트 삭제 폼 요청      get    /post/delete
    @GetMapping("/delete")
    public String delete(@ModelAttribute("postNo") Long postNo, Model model) {
        log.info("PostController /post/delete  GET 요청!! - {}", postNo);

        return "post/process-delete";
    }

    //    포스트 삭제 요청  post    /post/delete
    @PostMapping("/delete")
    public String delete(Long postNo, RedirectAttributes ra) {
        log.info("PostController /post/delete  POST 요청!! - {}", postNo);
        boolean flag = postService.removeService(postNo);

        if (flag){
            ra.addFlashAttribute("del-msg", "del-success");
        } else {
            ra.addFlashAttribute("del-msg", "del-fail");
        }
        return  "redirect:/list";
    }


    //    포스트 상세 조회 요청  get   /post/detail

    @GetMapping("/detail/{postNo}")
    public String postDetail(@PathVariable Long postNo, Model model) {
        log.info("PostController /post/detail/{}  GET 요청!!", postNo);

        model.addAttribute("p", postService.fineOnePostWithName(postNo)); //  PostWithName
        model.addAttribute("tagList", hashTagService.findAllByPostNo(postNo)); // List<HashtagDomain>
        model.addAttribute("imgList", imgService.getPostImgList(postNo));  // List<PostImg>
        model.addAttribute("date", postService.convertDate(postService.findOnePostService(postNo)));

        return "post/post-detail";
    }


}