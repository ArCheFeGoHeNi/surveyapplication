package hh.swd22.project.surveyapp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MultiAnswerOption {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long multiAnswerOptionsId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn
    private MultiQuestion multiQuestion;

    private String answerOption;

    public MultiAnswerOption() {

    }

    public MultiAnswerOption(String answerOption) {
        this.answerOption = answerOption;
    }

}
