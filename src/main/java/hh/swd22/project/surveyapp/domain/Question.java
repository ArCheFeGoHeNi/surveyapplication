package hh.swd22.project.surveyapp.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionID;
    private String question;
    private String questiontype;
    private Survey survey;

    public Question() {

    }

    public Question(String question, String questiontype, Survey survey) {
        this.question = question;
        this.questiontype = questiontype;
        this.survey = survey;
    }
}

