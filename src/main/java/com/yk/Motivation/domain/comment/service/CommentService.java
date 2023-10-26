package com.yk.Motivation.domain.comment.service;

import com.yk.Motivation.domain.comment.entity.Comment;
import com.yk.Motivation.domain.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> findByArticleId(long id) {
        return commentRepository.findByArticleId(id);
    }

    // 댓글 수정
    public void updateComment(long commentId, Comment comment) {
        Comment existingComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다."));

        existingComment.setContent(comment.getContent());
        existingComment.setRating(comment.getRating());
        commentRepository.save(existingComment);
    }

    // 댓글 삭제
    public void delete(long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다."));
        commentRepository.delete(comment);
    }

    // 댓글 조회 (ID 기반)
    public Comment findById(long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 댓글이 존재하지 않습니다."));
    }
}
