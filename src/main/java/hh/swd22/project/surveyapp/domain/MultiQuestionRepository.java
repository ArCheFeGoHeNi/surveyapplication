package hh.swd22.project.surveyapp.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MultiQuestionRepository extends CrudRepository<MultiQuestion, Long> {
	List<MultiQuestion> findByQuestionText(String multiQuestion);
}
