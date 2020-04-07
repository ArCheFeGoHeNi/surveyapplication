package hh.swd22.project.surveyapp.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Survey {

    //Automatically generating iterating id values
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long surveyId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "survey")
    private List<Question> questionList;

    private String surveyDesc;

    public Survey() {

    }

    public Survey(String surveyDesc, List<Question> questionList) {
        this.surveyDesc = surveyDesc;
        this.questionList = questionList;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public String getSurveyDesc() {
        return surveyDesc;
    }

    public void setSurveyDesc(String surveyDesc) {
        this.surveyDesc = surveyDesc;
    }
}