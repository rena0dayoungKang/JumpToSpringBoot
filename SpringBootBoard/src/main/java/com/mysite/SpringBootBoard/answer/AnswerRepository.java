package com.mysite.SpringBootBoard.answer;

import com.mysite.SpringBootBoard.answer.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

}
