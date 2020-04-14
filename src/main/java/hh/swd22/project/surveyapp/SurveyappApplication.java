package hh.swd22.project.surveyapp;

import hh.swd22.project.surveyapp.domain.*;
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
	public CommandLineRunner surveyDemo(QuestionRepository questionRepository,
										SurveyRepository surveyRepository,
										AnswerRepository answerRepository,
										RespondentRepository respondentRepository) {
		return (args) -> {

			Respondent respondent = new Respondent();

			respondentRepository.save(respondent);

			surveyRepository.save(new Survey("Opiskelu hyvinvointi", "Kysely opiskelijoiden hyvinvoinnista"));
			surveyRepository.save(new Survey("Työhyvinvointi", "Kysely työntekijöiden hyvinvoinnista"));
			surveyRepository.save(new Survey("Etäopiskelu kokemukset", "Kysely etäopiskelu kokemuksista"));

			log.info("fetch all surveys");
			for (Survey survey : surveyRepository.findAll()) {
				log.info(survey.toString());
			}

			questionRepository.save(new Question("Käytkö täysipäiväisesti töissä?", "text",
					surveyRepository.findBySurveyName("Opiskelu hyvinvointi").get(0)));
			questionRepository.save(new Question("Montako kertaa viikossa juot alkoholia?", "text",
					surveyRepository.findBySurveyName("Opiskelu hyvinvointi").get(0)));
			questionRepository.save(new Question("Miksi juot niin usein?", "text",
					surveyRepository.findBySurveyName("Opiskelu hyvinvointi").get(0)));

			log.info("fetch all questions");
			for (Question question : questionRepository.findAll()) {
				log.info(question.toString());
			}

			answerRepository.save(new Answer(respondent,
					questionRepository.findByQuestionText("Käytkö täysipäiväisesti töissä?").get(0),
					"Kyllä käyn"));
			answerRepository.save(new Answer(respondent,
					questionRepository.findByQuestionText("Montako kertaa viikossa juot alkoholia?").get(0),
					"Muutaman kerran"));
			answerRepository.save(new Answer(respondent,
					questionRepository.findByQuestionText("Miksi juot niin usein?").get(0),
					"En ymmärrä ;_;"));

			log.info("fetch all answers");
			for (Answer answer : answerRepository.findAll()) {
				log.info(answer.toString());
			}
			System.out.println("lolzz");
		};
	}
}