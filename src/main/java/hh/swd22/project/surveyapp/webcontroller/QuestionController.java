package hh.swd22.project.surveyapp.webcontroller;

import hh.swd22.project.surveyapp.domain.QuestionRepository;
import hh.swd22.project.surveyapp.domain.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private SurveyRepository surveyRepository;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index () {

        return "index"; //index.html

    }

    @RequestMapping(value = "/surveylist")
    public String surveyList(Model model) {

        model.addAttribute("surveyList", surveyRepository.findAll());

    }

}
