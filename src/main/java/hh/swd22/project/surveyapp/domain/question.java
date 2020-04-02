package hh.swd22.project.surveyapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionID;

    //private Survey survey;
    private String question;

    public question(long sID, String question) {
        this.surveyID = sID;
        this.question = question;
    }

    public long getQuestionID() {
        return questionID;
    }

    public void setQuestionID(long questionID) {
        this.questionID = questionID;
    }

    public long getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(long surveyID) {
        this.surveyID = surveyID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
