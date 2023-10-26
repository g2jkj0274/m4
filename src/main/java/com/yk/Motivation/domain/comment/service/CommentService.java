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
}
