package com.mysite.SpringBootBoard;

import com.mysite.SpringBootBoard.answer.Answer;
import com.mysite.SpringBootBoard.answer.AnswerRepository;
import com.mysite.SpringBootBoard.question.Question;
import com.mysite.SpringBootBoard.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SpringBootBoardApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

//	@Test
//	// @Test 애너테이션은 testJpa 메서드가 테스트 메서드임을 나타낸다.
//	// 위 클래스를 JUnit으로 실행하면 @Test 애너테이션이 붙은 메서드가 실행
//	void contextLoads() {
//		Question q1 = new Question();
//		q1.setSubject("sbb가 무엇인가요?");
//		q1.setContent("sbb에 대해서 알고 싶습니다.");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1);
//
//		Question q2 = new Question();
//		q2.setSubject("스프링부트 모델 질문입니다.");
//		q2.setContent("id는 자동으로 생성되나요?");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2);
//
//	}

//	@Test
//	void testJpa() {
//		List<Question> all = this.questionRepository.findAll();
//		//question 테이블에 저장된 모든 데이터를 조회하기 위해서 리포지터리의 findAll 메서드를 사용
//		assertEquals(4, all.size());
//		//assertEquals(2, all.size());
//		//assertEquals(기대값, 실제값)
//
//		Question q = all.get(0);
//		assertEquals("sbb가 무엇인가요?", q.getSubject());
//		//assertEquals("sbb가", q.getSubject());
//	}

//	@Test
//	void testJpa() {
//		Optional<Question> oq = this.questionRepository.findById(1);
//		//findById의 리턴 타입은 Question이 아닌 Optional임
//		//Optional은 null 처리를 유연하게 처리하기 위해 사용하는 클래스
//		if(oq.isPresent()) {
//			//isPresent로 null이 아닌지를 확인한 후
//			Question q = oq.get();
//			//get으로 실제 Question 객체 값을 얻어야 한다.
//			assertEquals("sbb가 무엇인가요?", q.getSubject());
//		}
//	}

//	@Test
//	void testJpa() {
//		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
//		assertEquals(1, q.getId());
//	}

//	@Test
//	void testJpa() {
//		Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
//		assertEquals(1, q.getId());
//	}

	//findBySubjectLike
//	@Test
//	void testJpa() {
//		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//		Question q = qList.get(0);
//		assertEquals("sbb가 무엇인가요?", q.getSubject());
//	}

	//데이터 수정하기
//	@Test
//	void testJpa() {
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		//assertTrue(값)은 값이 true인지를 테스트한다.
//		Question q = oq.get();
//		q.setSubject("수정된 제목");
//		this.questionRepository.save(q);
//	}

	//데이터 삭제하기
//	@Test
//	void testJpa() {
//		assertEquals(2, this.questionRepository.count());
//		//리포지터리의 count() 메서드는 해당 리포지터리의 총 데이터건수를 리턴한다.
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		this.questionRepository.delete(q);
//		assertEquals(1, this.questionRepository.count());
//	}

	//답변 데이터 생성 후 저장하기
//	@Test
//	void testJpa() {
//		Optional<Question> oq = this.questionRepository.findById(2);
//		//id가 2인 질문 데이터를 가져온 다음
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//
//		Answer a = new Answer();
//		a.setContent("네 자동으로 생성됩니다.");
//		a.setQuestion(q); //Answer 엔티티의 question속성에 질문 데이터를 대입
//		a.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(a);
//	}

	//답변 조회하기
//	@Test
//	void testJpa() {
//		Optional<Answer> oa = this.answerRepository.findById(1);
//		assertTrue(oa.isPresent());
//		Answer a = oa.get();
//		assertEquals(2, a.getQuestion().getId());
//	}

	//답변에 연결된 질문 찾기 vs 질문에 달린 답변 찾기
	@Transactional
	// @Transactional 애너테이션을 사용하면 메서드가 종료될 때까지 DB 세션이 유지된다.
	@Test
	void testJpa() {
		//질문 객체로부터 답변 리스트를 구하는 테스트코드
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		List<Answer> answerList = q.getAnswerList();

		assertEquals(1, answerList.size());
		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
	}

}
