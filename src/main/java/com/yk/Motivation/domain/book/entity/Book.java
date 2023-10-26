package com.yk.Motivation.domain.book.entity;

import com.yk.Motivation.base.jpa.baseEntity.BaseEntity;
import com.yk.Motivation.domain.bookTag.entity.BookTag;
import com.yk.Motivation.domain.document.standard.DocumentHavingTags;
import com.yk.Motivation.domain.document.standard.DocumentTag;
import com.yk.Motivation.domain.member.entity.Member;
import com.yk.Motivation.domain.postKeyword.entity.PostKeyword;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

import static lombok.AccessLevel.PROTECTED;

@Entity  // JPA Entity로 선언
@Setter  // Lombok: Setter 자동 생성
@Getter  // Lombok: Getter 자동 생성
@AllArgsConstructor(access = PROTECTED)  // 모든 필드 값을 인자로 받는 생성자 생성
@NoArgsConstructor(access = PROTECTED)  // 기본 생성자 생성
@SuperBuilder  // Lombok: Builder 패턴 구현
@ToString(callSuper = true)  // Lombok: toString 메서드 오버라이드
public class Book extends BaseEntity implements DocumentHavingTags {
    @ManyToOne  // 다대일 관계 설정
    private PostKeyword postKeyword;  // Book과 PostKeyword의 관계

    @ManyToOne  // 다대일 관계 설정
    private Member author;  // 책의 저자

    private String subject;  // 책 제목

    @Column(columnDefinition = "TEXT")
    private String body;  // 책 본문

    @Column(columnDefinition = "TEXT")
    private String bodyHtml;  // HTML 형식의 책 본문

    private boolean isPublic;  // 공개 여부

    @OneToMany(mappedBy = "book", orphanRemoval = true, cascade = {CascadeType.ALL})
    @Builder.Default
    @ToString.Exclude
    private Set<BookTag> bookTags = new HashSet<>(); // 책 태그들

    // DocumentHavingTags 의 추상메서드
    // 태그기능을 사용하려면 필요하다.
    @Override
    public Set<? extends DocumentTag> _getTags() {
        return bookTags;
    }

    // DocumentHavingTags 의 추상메서드
    // 태그기능을 사용하려면 필요하다.
    @Override
    public DocumentTag _addTag(String tagContent) {
        BookTag tag = BookTag.builder()
                .author(author)
                .book(this)
                .content(tagContent)
                .build();

        bookTags.add(tag);

        return tag;
    }

    public String getPublicHanName() {
        return isPublic ? "공개" : "비공개"; // 공개 여부를 문자열로 반환
    }

}