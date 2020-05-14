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
										RespondentRepository respondentRepository,
										MultiAnswerOptionRepository multiRepository
										) {
		return (args) -> {

			Respondent respondent = new Respondent();

			respondentRepository.save(respondent);

			surveyRepository.save(new Survey("Opiskeluhyvinvointi", "Kysely opiskeluhyvinvoinnista"));
			surveyRepository.save(new Survey("Työhyvinvointi", "Kysely työhyvinvoinnista"));
			surveyRepository.save(new Survey("Etäopiskelukokemukset", "Kysely etäopiskelukokemuksista"));

			log.info("fetch all surveys");
			for (Survey survey : surveyRepository.findAll()) {
				log.info(survey.toString());
			}

			questionRepository.save(new Question("Käytkö täysipäiväisesti töissä?", "text",
					surveyRepository.findBySurveyName("Opiskeluhyvinvointi").get(0)));
			questionRepository.save(new Question("Montako kertaa viikossa juot alkoholia?", "text",
					surveyRepository.findBySurveyName("Opiskeluhyvinvointi").get(0)));
			questionRepository.save(new Question("Miksi juot niin usein?", "text",
					surveyRepository.findBySurveyName("Opiskeluhyvinvointi").get(0)));
			questionRepository.save(new Question("Öö mee töihin?", "text",
					surveyRepository.findBySurveyName("Työhyvinvointi").get(0)));
			questionRepository.save(new Question("Pitäskö mennä töihin senkin yhteiskunnan loiseliö?", "text",
					surveyRepository.findBySurveyName("Työhyvinvointi").get(0)));
			questionRepository.save(new Question("Kauan olet ollut ulkomailla opiskelemassa?", "text",
					surveyRepository.findBySurveyName("Etäopiskelukokemukset").get(0)));
			questionRepository.save(new Question("Minkälaista palkkaa sait?", "text",
					surveyRepository.findBySurveyName("Etäopiskelukokemukset").get(0)));
			questionRepository.save(new Question("Mikä seuraavista on parasta?", "multiplechoice",
					surveyRepository.findBySurveyName("Etäopiskelukokemukset").get(0)));
			questionRepository.save(new Question("Mikä on paras safka päivän aikana?", "multiplechoice",
					surveyRepository.findBySurveyName("Etäopiskelukokemukset").get(0)));
			
			multiRepository.save(new MultiAnswerOption("Kesä", questionRepository.findByQuestionText("Mikä seuraavista on parasta?").get(0)));
			multiRepository.save(new MultiAnswerOption("Talvi", questionRepository.findByQuestionText("Mikä seuraavista on parasta?").get(0)));
			multiRepository.save(new MultiAnswerOption("Syksy", questionRepository.findByQuestionText("Mikä seuraavista on parasta?").get(0)));
			multiRepository.save(new MultiAnswerOption("Kevät", questionRepository.findByQuestionText("Mikä seuraavista on parasta?").get(0)));

			multiRepository.save(new MultiAnswerOption("Aamupala", questionRepository.findByQuestionText("Mikä on paras safka päivän aikana?").get(0)));
			multiRepository.save(new MultiAnswerOption("Välipala", questionRepository.findByQuestionText("Mikä on paras safka päivän aikana?").get(0)));
			multiRepository.save(new MultiAnswerOption("Haab", questionRepository.findByQuestionText("Mikä on paras safka päivän aikana?").get(0)));
			multiRepository.save(new MultiAnswerOption("Päivällinen", questionRepository.findByQuestionText("Mikä on paras safka päivän aikana?").get(0)));
			multiRepository.save(new MultiAnswerOption("Illallinen", questionRepository.findByQuestionText("Mikä on paras safka päivän aikana?").get(0)));
			multiRepository.save(new MultiAnswerOption("Yöllinen", questionRepository.findByQuestionText("Mikä on paras safka päivän aikana?").get(0)));

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
			
			//multiRepo.save(new MultiQuestion("LOLLERO."));

			log.info("fetch all answers");
			for (Answer answer : answerRepository.findAll()) {
				log.info(answer.toString());
			}
			System.out.println("Working as intended.");
		};
	}
}