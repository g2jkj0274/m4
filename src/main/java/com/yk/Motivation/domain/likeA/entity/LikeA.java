package com.yk.Motivation.domain.likeA.entity;

import com.yk.Motivation.base.jpa.baseEntity.BaseEntity;
import com.yk.Motivation.domain.article.entity.Article;
import com.yk.Motivation.domain.member.entity.Member;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class LikeA extends BaseEntity {
    @ManyToOne                      // JPA 어노테이션으로 Member 엔티티와 다대일 관계임을 나타냄.
    @JoinColumn(name = "member_id") // 연관 엔티티의 FK 컬럼 이름을 명시함.
    private Member member;          // Member 엔티티를 참조하는 필드

    @ManyToOne                      // JPA 어노테이션으로 Article 엔티티와 다대일 관계임을 나타냄.
    @JoinColumn(name = "article_id")// 연관 엔티티의 FK 컬럼 이름을 명시함.
    private Article article;        // Article 엔티티를 참조하는 필드

    // equals() 메서드를 오버라이드. member와 article을 기준으로 같은 객체인지 판별함.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LikeA)) return false;

        LikeA that = (LikeA) o;

        if (!member.equals(that.member)) return false;
        return article.equals(that.article);
    }

    // hashCode() 메서드를 오버라이드. member와 article을 기준으로 해시 코드를 생성함.
    @Override
    public int hashCode() {
        int result = member.hashCode();
        result = 31 * result + article.hashCode();
        return result;
    }
}
