
package hh.swd22.project.surveyapp.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity //Entity Class
public class Question {

    private String questionText;
    private String questionType;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionID;

    @ManyToOne
    @JsonManagedReference //Critical for stopping endless looping
    @JoinColumn
    private Survey survey;

    public Question() {

    }

    public Question(String questionText, String questionType, Survey survey) {
        this.questionText = questionText;
        this.questionType = questionType;
        this.survey = survey;
    }

    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String question) {
        this.questionText = question;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questiontype) {
        this.questionType = questiontype;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

}