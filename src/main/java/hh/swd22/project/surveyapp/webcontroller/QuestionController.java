package hh.swd22.project.surveyapp.webcontroller;

import hh.swd22.project.surveyapp.domain.Question;
import hh.swd22.project.surveyapp.domain.QuestionRepository;
import hh.swd22.project.surveyapp.domain.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Optional;

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
    @RequestMapping(value = "/savequestion", method = RequestMethod.POST)
    public String saveQuestion(Question question) {
        questionRepository.save(question);
        return "redirect:questionlist"; //Redirects to /questionlist endpoint
    }


    //RESTFUL SERVICE ENDPOINTS

    @CrossOrigin
    @RequestMapping(value = "/questions", method = RequestMethod.GET) // CrossOrigin for requests from another service, no parameters needed now - Arttu K, 09.04.2020.
    public @ResponseBody List<Question> questions() {
        return (List<Question>) questionRepository.findAll();
    }
    
     //RESTful service to get one product by id.
  	@CrossOrigin
  	@RequestMapping(value = "/questions/{id}", method = RequestMethod.GET)
  	public @ResponseBody Optional <Question> findQuestionRest(@PathVariable Long id) { // Täytyy olla id, ei toimi  tässä! Arttu Kesanto 09.04.2020.
  		return questionRepository.findById(id); // Laitetaan util-importti optional, jotta voidaan käyttää PathVariablea myös tässä.
  	}
  	
  	
    @CrossOrigin
    @RequestMapping(value = "/questions", method = RequestMethod.POST) // CrossOrigin for requests from another service, no parameters needed now - Arttu K, 09.04.2020.
    public @ResponseBody Question saveQuestionRest(@RequestBody Question question ) {
    	return questionRepository.save(question);
    }
    
    // Home page of REST services, Template created with examples, no need for @CrossOrigin
    @RequestMapping(value="/resthome", method = RequestMethod.GET)
    public String getRestHome() {	
    	return "resthome"; // resthome.html, oma tiedosto, ei tule importtien kautta. - Arttu Kesanto 09.04.2020.
    }
}

