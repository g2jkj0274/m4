package com.yk.Motivation.domain.comment.controller;

import com.yk.Motivation.domain.comment.entity.Comment;
import com.yk.Motivation.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    // 댓글 수정 페이지로 이동
    @GetMapping("/modify/{commentId}")
    public String showModify(@PathVariable long commentId) {
        return "comment/modify";
    }

    // 댓글 수정 처리
    @PostMapping("/modify/{commentId}")
    public String modify(@PathVariable long commentId, @ModelAttribute Comment comment) {
        commentService.updateComment(commentId, comment);
        return "redirect:/usr/article/free1/detail/" + comment.getArticle().getId();
    }

    // 댓글 삭제 처리
    @RequestMapping(value = "/delete/{commentId}", method = RequestMethod.GET)
    public String delete(@PathVariable long commentId) {
        Comment comment = commentService.findById(commentId);
        long articleId = comment.getArticle().getId();
        commentService.delete(commentId);
        return "redirect:/usr/article/free1/detail/" + articleId;
    }
}
