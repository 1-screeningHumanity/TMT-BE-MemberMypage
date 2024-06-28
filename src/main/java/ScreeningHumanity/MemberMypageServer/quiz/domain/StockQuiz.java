package ScreeningHumanity.MemberMypageServer.quiz.domain;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document("stock_quiz")
public class StockQuiz {

	@Id
	private String id;
	private String question;
	private String answer;
	private String comment;

}
