package ScreeningHumanity.MemberMypageServer.quiz.dto.in;

import ScreeningHumanity.MemberMypageServer.quiz.domain.StockQuiz;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StockQuizDto {

	private String question;
	private String answer;
	private String comment;

	public static List<StockQuizDto> getStockQuiz(List<StockQuiz> stockQuizzes) {
		return stockQuizzes.stream()
				.map(stockQuiz ->
						StockQuizDto.builder()
								.question(stockQuiz.getQuestion())
								.answer(stockQuiz.getAnswer())
								.comment(stockQuiz.getComment())
								.build())
				.toList();
	}
}
