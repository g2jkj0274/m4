package com.yk.Motivation.domain.qna.entity;

import com.yk.Motivation.base.jpa.baseEntity.BaseEntity;
import com.yk.Motivation.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PROTECTED;

@Entity  // JPA Entity로 선언
@Setter  // Lombok: Setter 자동 생성
@Getter  // Lombok: Getter 자동 생성
@AllArgsConstructor(access = PROTECTED)  // 모든 필드 값을 인자로 받는 생성자 생성
@NoArgsConstructor(access = PROTECTED)
@SuperBuilder  // Lombok: Builder 패턴 구현
@ToString(callSuper = true)  // Lombok: toString 메서드 오버라이드
public class Question extends BaseEntity {
    @Column(nullable = false)
    private int lectureId;  // 강의 ID

    private int curriculumId;  // 커리큘럼 ID

    @Column(nullable = false, length = 255)
    private String title;  // 질문 제목

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;  // 질문 내용

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;  // 질문을 작성한 사용자

    @Column(nullable = false)
    private boolean answerStatus = false;  // 답변 상태. 기본값은 false(미등록).

}
