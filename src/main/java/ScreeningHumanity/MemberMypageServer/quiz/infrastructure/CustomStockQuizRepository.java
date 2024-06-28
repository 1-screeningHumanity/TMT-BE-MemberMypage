package ScreeningHumanity.MemberMypageServer.quiz.infrastructure;

import ScreeningHumanity.MemberMypageServer.quiz.domain.StockQuiz;
import java.util.List;

public interface CustomStockQuizRepository {
	List<StockQuiz> getRandomStockQuiz();
}
