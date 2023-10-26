package com.yk.Motivation.domain.comment.controller;

import com.yk.Motivation.domain.comment.entity.Comment;
import com.yk.Motivation.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usr/comment")
@RequiredArgsConstructor

public class CommentController {

    private final CommentService commentService;

    @PostMapping("/write")
    public String write(@ModelAttribute Comment comment) {
        commentService.save(comment);
        return "redirect:/usr/article/free1/detail/" + comment.getArticle().getId();  // 댓글을 단 게시글로 리다이렉트
    }
}
