package hh.swd22.project.surveyapp.webcontroller;

import hh.swd22.project.surveyapp.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class AnswerController {
	@Autowired
    private AnswerRepository answerRepository;
	
	@Autowired
    private QuestionRepository questionRepository;

    @CrossOrigin
    @RequestMapping(value = "/answers", method = RequestMethod.POST)
    public @ResponseBody void saveAnswerRest (@RequestBody List<String> answertextList, List<Long> questionID) {
        Respondent respondent = new Respondent();

        for (int i = 0; i < answertextList.size(); i++) {
            answerRepository.save(new Answer(respondent, questionRepository.findById(questionID.get(i)).get(), answertextList.get(i)));
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/answers", method = RequestMethod.GET) // CrossOrigin for requests from another service, no parameters needed now - Arttu K, 09.04.2020.
    public @ResponseBody List<Answer> answers() {
        return (List<Answer>) answerRepository.findAll();
    }
}