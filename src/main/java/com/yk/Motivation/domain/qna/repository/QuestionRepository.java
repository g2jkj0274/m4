package com.yk.Motivation.domain.qna.repository;

import com.yk.Motivation.domain.qna.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject);
    Question findBySubjectAndContent(String title, String content);
    List<Question> findBySubjectLike(String titlePattern);
}
