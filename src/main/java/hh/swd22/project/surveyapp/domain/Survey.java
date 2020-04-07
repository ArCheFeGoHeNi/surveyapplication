package hh.swd22.project.surveyapp.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

@Entity
public class Survey {

    //Automatically generating iterating id values
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long surveyId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "survey")
    @JsonBackReference
    private List<Question> questionList;

    private String surveyDesc;

    public Survey() {

    }

    public Survey(String surveyDesc) {
        this.surveyDesc = surveyDesc;
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

    @Override
    public String toString() {
        return surveyDesc;
    }
}