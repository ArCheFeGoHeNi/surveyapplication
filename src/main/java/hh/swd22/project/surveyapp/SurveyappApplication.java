package hh.swd22.project.surveyapp;

import hh.swd22.project.surveyapp.domain.Question;
import hh.swd22.project.surveyapp.domain.QuestionRepository;
import hh.swd22.project.surveyapp.domain.Survey;
import hh.swd22.project.surveyapp.domain.SurveyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SurveyappApplication {

	private static final Logger log = LoggerFactory.getLogger(SurveyappApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SurveyappApplication.class, args);
	}

	@Bean
	public CommandLineRunner surveyDemo(QuestionRepository questionRepository, SurveyRepository surveyRepository) {
		return (args) -> {

			surveyRepository.save(new Survey("Opiskelu hyvinvointi"));
			surveyRepository.save(new Survey("Työhyvinvointi"));
			surveyRepository.save(new Survey("Etäopiskelu kokemukset"));

			questionRepository.save(new Question("Käytkö täysipäiväisesti töissä?", "text",
													surveyRepository.findBySurveyName("Opiskelu hyvinvointi").get(0)));
			questionRepository.save(new Question("Montako kertaa viikossa juot alkoholia?", "text",
													surveyRepository.findBySurveyName("Opiskelu hyvinvointi").get(0)));
			questionRepository.save(new Question("Miksi juot niin usein?", "text",
													surveyRepository.findBySurveyName("Opiskelu hyvinvointi").get(0)));

		};
	}

}