package com.cognizant.hqllearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.hqllearn.model.Attempt;
import com.cognizant.hqllearn.model.AttemptQuestion;
import com.cognizant.hqllearn.model.Options;
import com.cognizant.hqllearn.model.Question;
import com.cognizant.hqllearn.service.AttemptService;

@SpringBootApplication
public class HqlLearnApplication {
	
	private static AttemptService attemptService;
	private static final Logger LOGGER = LoggerFactory.getLogger(HqlLearnApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Inside main");
		ApplicationContext ctx = SpringApplication.run(HqlLearnApplication.class, args);
		attemptService = ctx.getBean(AttemptService.class);
		testGetAttempt();
	}
	
	private static void testGetAttempt()
	{
		Attempt attempt = attemptService.getAttempt(1, 3);
		LOGGER.info("Start of test");
		for(AttemptQuestion attemptQuestion : attempt.getAttemptQuestionList())
		{
			int i = 1;
			Question question = attemptQuestion.getQuestionFromAQ();
			LOGGER.debug(question.getText());
			for(Options option : question.getOptions())
			{
				LOGGER.debug(i+" "+option.getText()+"\t"+option.getScore()+"\t"+option.getAttemptOptionList().toString());
				i++;
			}
		}
		LOGGER.info("End of test");
	}
}
