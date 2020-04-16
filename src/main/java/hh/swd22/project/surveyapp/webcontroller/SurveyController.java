package hh.swd22.project.surveyapp.webcontroller;

import hh.swd22.project.surveyapp.domain.Answer; 
import hh.swd22.project.surveyapp.domain.Survey;
import hh.swd22.project.surveyapp.domain.SurveyRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SurveyController {
	
    @Autowired
    private SurveyRepository surveyRepository;

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

    //Endpoing /save saves the survey to the database and redirects to /surveylist endpoint 
    @RequestMapping(value = "/savesurvey", method = RequestMethod.POST)
    public String saveQuestion(Survey survey) {
        surveyRepository.save(survey);
        return "redirect:surveylist"; //Redirects to /surveylist endpoint
    }
    
    
    //REST for Surveys.
    
    @CrossOrigin
    @RequestMapping(value = "/surveyslist", method = RequestMethod.GET) // CrossOrigin for requests from another service, no parameters needed now - Arttu K, 09.04.2020.
    public @ResponseBody List<Survey> surveys() {
        return (List<Survey>) surveyRepository.findAll();
    }
    
    @CrossOrigin
    @RequestMapping(value = "/surveyslist/{id}", method = RequestMethod.GET) // CrossOrigin for requests from another service, no parameters needed now - Arttu K, 09.04.2020.
    public @ResponseBody Optional <Survey> surveysById(@PathVariable Long id) {
        return surveyRepository.findById(id);
    }
}
