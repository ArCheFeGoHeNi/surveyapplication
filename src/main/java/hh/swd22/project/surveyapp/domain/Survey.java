package hh.swd22.project.surveyapp.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Survey {

    //Automatically generating iterating id values
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long surveyId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "survey")
    private List<Question> questionList;

    private String surveyDesc;

    public Survey() {

    }

}

