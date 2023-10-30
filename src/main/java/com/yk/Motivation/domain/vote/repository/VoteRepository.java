package com.yk.Motivation.domain.vote.repository;

import com.yk.Motivation.domain.vote.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    // 필요한 쿼리 메서드 추가 가능
}
