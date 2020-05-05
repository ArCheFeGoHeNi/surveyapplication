package hh.swd22.project.surveyapp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class MultiQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long MultiQuestionId;

    private String questionText;

    @OneToMany
    @JsonManagedReference
    private List<MultiAnswerOption> multiAnswerOptions;

    @ManyToOne
    @JsonBackReference
    @JoinColumn
    private Survey survey;

    @OneToMany
    @JsonManagedReference
    private List<Answer> answerList;

    public MultiQuestion () {
    }

    public MultiQuestion (String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<MultiAnswerOption> getMultiAnswerOptions() {
        return multiAnswerOptions;
    }

    public void setMultiAnswerOptions(List<MultiAnswerOption> multiAnswerOptions) {
        this.multiAnswerOptions = multiAnswerOptions;
    }

    public void setMultiAnswerOption(MultiAnswerOption multiAnswerOption) {
        this.multiAnswerOptions.add(multiAnswerOption);
    }

    public Long getMultiQuestionId() {
        return MultiQuestionId;
    }

    public void setMultiQuestionId(Long multiQuestionId) {
        MultiQuestionId = multiQuestionId;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }
}