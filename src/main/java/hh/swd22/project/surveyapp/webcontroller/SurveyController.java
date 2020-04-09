package hh.swd22.project.surveyapp.webcontroller;

import hh.swd22.project.surveyapp.domain.Question;
import hh.swd22.project.surveyapp.domain.QuestionRepository;
import hh.swd22.project.surveyapp.domain.Survey;
import hh.swd22.project.surveyapp.domain.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SurveyController {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private QuestionRepository questionRepository;

    //Mapping /surveylist endpoint to thymeleaf template surveylist.html
    @RequestMapping(value = "/surveylist", method = RequestMethod.GET)
    public String surveyList(Model model) {

        model.addAttribute("surveyList", surveyRepository.findAll());

        return "surveylist"; //surveylist.html

    }

    //Mapping endpoint /addsurvey to addsurvey.html thymeleaf template in /resources/templates/
    @RequestMapping(value = "/addsurvey", method = RequestMethod.GET)
    public String addQuestion(Model model) {

        model.addAttribute("survey", new Survey());

        return "addsurvey"; //addquestion.html

    }

    //Endpoing /save saves the song to the database and redirects to /questionlist endpoint
    @RequestMapping(value = "/savesurvey", method = RequestMethod.POST)
    public String saveQuestion(Survey survey) {

        surveyRepository.save(survey);

        return "redirect:surveylist"; //Redirects to /questionlist endpoint
    }

}
