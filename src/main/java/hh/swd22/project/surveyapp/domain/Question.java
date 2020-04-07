<<<<<<< HEAD
package hh.swd22.project.surveyapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity //Entity Class not adding piste this time around
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionID;

    @ManyToOne
    @JsonManagedReference //Critical for stopping endless looping
    @JoinColumn
    private Survey survey;

    private String question;
    private String questiontype;

    public Question() {

    }

    public Question(String question, String questiontype, Survey survey) {
        this.question = question;
        this.questiontype = questiontype;
        this.survey = survey;
    }

    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestiontype() {
        return questiontype;
    }

    public void setQuestiontype(String questiontype) {
        this.questiontype = questiontype;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }
=======
package hh.swd22.project.surveyapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity //Entity Class
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionID;

    @ManyToOne
    @JsonManagedReference //Critical for stopping endless looping
    @JoinColumn
    private Survey survey;

    private String question;
    private String questiontype;

    public Question() {

    }

    public Question(String question, String questiontype, Survey survey) {
        this.question = question;
        this.questiontype = questiontype;
        this.survey = survey;
    }

    public Long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Long questionID) {
        this.questionID = questionID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestiontype() {
        return questiontype;
    }

    public void setQuestiontype(String questiontype) {
        this.questiontype = questiontype;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }
>>>>>>> a65a3028fe54c51a09f7ee0189a2e29104f05676
}