package hh.swd22.project.surveyapp.webcontroller;

import hh.swd22.project.surveyapp.domain.Question;
import hh.swd22.project.surveyapp.domain.QuestionRepository;
import hh.swd22.project.surveyapp.domain.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private SurveyRepository surveyRepository;

    //Mapping /index endpoint to thymeleaf template index.html
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {

        return "index"; //index.html

    }

    //Mapping /surveylist endpoint to thymeleaf template surveylist.html
    @RequestMapping(value = "/surveylist", method = RequestMethod.GET)
    public String surveyList(Model model) {

        model.addAttribute("surveyList", surveyRepository.findAll());

        return "surveylist"; //surveylist.html

    }

    //Mapping /questionlist endpoint to thymeleaf template questionlist.html
    @RequestMapping(value = "/questionlist", method = RequestMethod.GET)
    public String questionList(Model model) {

        model.addAttribute("questionList", questionRepository.findAll());

        return "questionlist"; //questionlist.html

    }

    //Mapping endpoint /addquestion to addquestion.html thymeleaf template in /resources/templates/
    @RequestMapping(value = "/addquestion", method = RequestMethod.GET)
    public String addQuestion(Model model) {

        model.addAttribute("question", new Question());
        model.addAttribute("surveys", surveyRepository.findAll());

        return "addquestion"; //addquestion.html

    }

    //Endpoing /save saves the song to the database and redirects to /questionlist endpoint
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveQuestion(Question question) {

        questionRepository.save(question);

        return "redirect:questionlist"; //Redirects to /questionlist endpoint
    }


    //RESTFUL SERVICE ENDPOINTS

    @CrossOrigin
    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public @ResponseBody List<Question> questions() {

        return (List<Question>) questionRepository.findAll();

    }
}
