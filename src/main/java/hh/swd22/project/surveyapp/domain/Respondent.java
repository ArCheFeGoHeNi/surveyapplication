package hh.swd22.project.surveyapp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Respondent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long RespondentID;

    @OneToMany
    @JsonBackReference
    private List<Answer> answerList;

    public Respondent(List<Answer> answers) {
        this.answerList = answers;
    }

    public Respondent() {}

}
