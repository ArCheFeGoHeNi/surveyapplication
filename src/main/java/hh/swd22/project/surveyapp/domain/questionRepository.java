package hh.swd22.project.surveyapp.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface questionRepository extends CrudRepository<Question, Long> {
    List<Question> findByName(String question);
}
