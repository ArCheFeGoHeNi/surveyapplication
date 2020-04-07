package hh.swd22.project.surveyapp.webcontroller;

import hh.swd22.project.surveyapp.domain.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SurveyController {

    @Autowired
    private SurveyRepository surveyRepository;



}
