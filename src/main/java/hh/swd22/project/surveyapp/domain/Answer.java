package hh.swd22.project.surveyapp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long answerID;

    @ManyToOne
    @JsonManagedReference
    private Respondent respondent;

    @ManyToOne
    @JsonManagedReference
    private Question question;

    private String answerText;

    public Answer () {}

    public Answer(Respondent respondent, Question question, String answerText) {
        this.respondent = respondent;
        this.question = question;
        this.answerText = answerText;
    }

}
