package hh.swd22.project.surveyapp.webcontroller;

import hh.swd22.project.surveyapp.domain.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {

        return "index"; //index.html

    }

}
