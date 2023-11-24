package com.mysite.SpringBootBoard;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @ManyToOne //하나의 질문에 답변 여러개가 달릴 수 있는 구조
    private Question question;
    //question 속성은 답변 엔티티에서 질문 엔티티를 참조하기 위해 추가
    //속성만 추가하면 안되고 질문 엔티티와 연결된 속성이라는 것을 명시적으로 표시해야 한다.
    //question 속성에 @ManyToOne 애너테이션을 추가해야 한다. -> Question 클래스에서는 @OneToMany 추가

}
