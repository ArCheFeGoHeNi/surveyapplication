package hh.swd22.project.surveyapp.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
	List<Answer> findByAnswerText(String answerText);
}
