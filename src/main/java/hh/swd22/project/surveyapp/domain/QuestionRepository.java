package hh.swd22.project.surveyapp.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {
    List<Question> findByQuestionText(String question);
    List<Question> findByQuestionType(String questionType);
}
