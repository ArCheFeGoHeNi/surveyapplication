package hh.swd22.project.surveyapp.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MultiAnswerOptionRepository extends CrudRepository<MultiAnswerOption, Long> {
	List<MultiAnswerOption> findByAnswerOption(String multiAnswerOption);
}


