package com.ibini.my_books.postmemo.repository;

import com.ibini.my_books.postmemo.domain.PostMemo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMemoMapper {

    // 메모 저장 기능
    boolean save(PostMemo postMemo);

    // 메모 수정 기능
    boolean modify(PostMemo postMemo);

    // 메모 삭제 기능
    boolean remove(Long memoNo);

    // 메모 전체 삭제 기능 (포스트에 달린 모든 메모 삭제)
    boolean removeAll(Long postNo);

    // 메모 전체 조회 기능
    List<PostMemo> findAll(Long postNo); // 페이징 처리 추후 추가 예정

    // 메모 개별 조회 기능
    PostMemo findOne(Long memoNo);

    // 전체 메모 수 조회
    int getPostMemoCount(Long postNo);
}
