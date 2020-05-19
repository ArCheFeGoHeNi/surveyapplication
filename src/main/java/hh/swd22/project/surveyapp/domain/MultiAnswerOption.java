package hh.swd22.project.surveyapp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MultiAnswerOption {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long multiAnswerOptionsId;

    private String answerOption;
    
    @ManyToOne
    //@JsonIgnore
    //@JsonManagedReference
    @JsonBackReference
    @JoinColumn
    private Question question;

    

    public MultiAnswerOption() {

    }
    
    public MultiAnswerOption(String answerOption, Question question) {
		super();
		this.answerOption = answerOption;
		this.question = question;
		
	}
    
    public MultiAnswerOption(Question question) { // Created to start a new MultiChoice with a pre-determined question.
    	this.question = question;

    }

	public MultiAnswerOption(String answerOption) {
        this.answerOption = answerOption;
    }

	public Long getMultiAnswerOptionsId() {
		return multiAnswerOptionsId;
	}

	public void setMultiAnswerOptionsId(Long multiAnswerOptionsId) {
		this.multiAnswerOptionsId = multiAnswerOptionsId;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getAnswerOption() {
		return answerOption;
	}

	public void setAnswerOption(String answerOption) {
		this.answerOption = answerOption;
	}

	
    

}
