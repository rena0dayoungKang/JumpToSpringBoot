package com.mysite.SpringBootBoard.question;

import com.mysite.SpringBootBoard.answer.Answer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity //엔티티로 만들기 위한 어노테이션을 적용해야 JPA가 엔티티로 인식함.
public class Question {

    @Id //고유번호 id 속성을 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //GeneratedValue = 자동으로 1씩 증가하여 저장
    //strategy = 고유번호를 생성하는 옵션
    //GenerationType.IDENTITY = 해당 컬럼만의 독립적인 시퀀스 생성하여 번호 증가시킴
    private Integer id;

    @Column(length = 200)
    //테이블의 컬럼명과 일치
    private String subject;

    @Column(columnDefinition = "TEXT")
    //"내용"처럼 글자 수를 제한할 수 없는 경우 사용
    private String content;

    private LocalDateTime createDate;
    //createDate 속성의 실제 테이블의 컬럼명은 create_date가 된다.

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
    //Answer 엔티티 객체로 구성된 answerList를 속성으로 추가하고 @OneToMany 애너테이션을 설정
}
