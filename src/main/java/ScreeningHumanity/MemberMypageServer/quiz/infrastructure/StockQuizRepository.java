package ScreeningHumanity.MemberMypageServer.quiz.infrastructure;

import ScreeningHumanity.MemberMypageServer.quiz.domain.StockQuiz;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockQuizRepository extends MongoRepository<StockQuiz, String>,
		CustomStockQuizRepository {


}
