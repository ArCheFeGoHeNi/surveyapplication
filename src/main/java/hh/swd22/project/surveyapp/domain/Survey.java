package hh.swd22.project.surveyapp.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

@Entity
public class Survey {

    //Automatically generating iterating id values
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long surveyId;

    private String surveyName;
    private String surveyDesc;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "survey")
    @JsonManagedReference //Parent level
    //@JsonBackReference
    private List<Question> questionList;


    public Survey() {

    }

    public Survey(String surveyName, String surveyDesc) {
        this.surveyName = surveyName;
        this.surveyDesc = surveyDesc;
    }

    //Another constructor so it's possible to create a survey without giving it a description
    public Survey(String surveyName) {
        this.surveyName = surveyName;
    }

    public Long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public String getSurveyDesc() {
		return surveyDesc;
	}

	public void setSurveyDesc(String surveyDesc) {
		this.surveyDesc = surveyDesc;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	@Override
    public String toString() {
        return surveyName;
    }
}