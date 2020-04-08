package hh.swd22.project.surveyapp.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SurveyRepository extends CrudRepository<Survey, Long> {
    List<Survey> findBySurveyName(String surveyName);
}
