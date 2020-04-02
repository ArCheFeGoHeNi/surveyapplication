package hh.swd22.project.surveyapp.domain;

import javax.persistence.Entity;

@Entity
public class Question {

    private String questiontype;
    private Survey survey;

}
