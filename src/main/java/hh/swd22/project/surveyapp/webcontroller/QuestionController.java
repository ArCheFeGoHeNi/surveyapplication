package hh.swd22.project.surveyapp.webcontroller;

import hh.swd22.project.surveyapp.domain.MultiAnswerOption;
import hh.swd22.project.surveyapp.domain.MultiAnswerOptionRepository;
import hh.swd22.project.surveyapp.domain.Question;
import hh.swd22.project.surveyapp.domain.QuestionRepository;
import hh.swd22.project.surveyapp.domain.Survey;
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
    
    @Autowired
    private MultiAnswerOptionRepository multiRepo;

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
    
    //creating an endpoint which grants the option to add multiplechoiceanswers to a single question - Arttu K.
    @RequestMapping(value = "/question/{id}/addmultichoice", method = RequestMethod.GET)
    public String addQuestionsToSurvey(@PathVariable("id") Long id, Model model) {

        Optional<Question> questionOptional = questionRepository.findById(id);

        Question question = questionOptional.get(); // Getting rid of the Optional Wrapper. Same as Surveys.

        Long questionId = question.getQuestionID(); // Getting the id for saving to Model-class... Possible to get this via question solely.


        model.addAttribute("thisquestion", question);
        model.addAttribute("thisquestionId", questionId);
        model.addAttribute("multiAnswer", new MultiAnswerOption(question)); // A question + an answer option with pre-determined Question class values. 
        // Created a constructor with only the Question class as a parameter for the MultiAnswerOption class. Arttu K, 19.05.2020.
        model.addAttribute("multichoices", multiRepo.findAll()); // Getting all answer options; matching these via ID:s (Foreign Key and Primary Key) on the template.
        return "addmultichoiceoptions";
    }

   /* @RequestMapping(value = "/addmultioptions", method = RequestMethod.GET) !! OLD AND OBSOLETE - Arttu K.
    public String addMultiOptions(Model model) {
        model.addAttribute("multiOption", new MultiAnswerOption());
        model.addAttribute("multiChoiceQuestions", multiRepo.findAll());
        return "addmultichoiceoptions"; //addmultihoiceoptions.html
    } */
    
    @RequestMapping(value = "/savemultioption", method = RequestMethod.POST) // Added to be able to save a multioption.
    public String saveMultiOption(MultiAnswerOption multiOption) {
        multiRepo.save(multiOption);
        // System.out.println(question.getSurvey()); Not in use now. Arttu K, 28.04.2020.
        return "redirect:questionlist"; //Redirects to /questionlist endpoint
    }


    @RequestMapping(value = "/savequestion", method = RequestMethod.POST)
    public String saveQuestion(Question question) {
        questionRepository.save(question);
        // System.out.println(question.getSurvey()); Not in use now. Arttu K, 28.04.2020.
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

