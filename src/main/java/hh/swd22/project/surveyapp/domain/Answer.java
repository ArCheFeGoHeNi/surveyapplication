package hh.swd22.project.surveyapp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;


@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long answerID;

    private String answerText;
    //@ManyToOne
    //@JsonManagedReference //Parent Level
    //@JsonBackReference
    //private Respondent respondent;

    @ManyToOne
    //@JsonIgnore
    //@JsonManagedReference
    @JsonBackReference //Child level
    private Question question;
    
    

    public Answer () {
    }

    public Answer(Respondent respondent, Question question, String answerText) {
        //this.respondent = respondent;
        this.question = question;
        this.answerText = answerText;
    }

	public Long getAnswerID() {
		return answerID;
	}

	public void setAnswerID(Long answerID) {
		this.answerID = answerID;
	}

/*	public Respondent getRespondent() {
		return respondent;
	}

	public void setRespondent(Respondent respondent) {
		this.respondent = respondent;
	} */

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
}
