package ScreeningHumanity.MemberMypageServer.quiz.infrastructure;


import static org.springframework.data.mongodb.core.aggregation.Aggregation.sample;

import ScreeningHumanity.MemberMypageServer.quiz.domain.StockQuiz;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CustomStockQuizRepositoryImpl implements CustomStockQuizRepository {
	private final MongoTemplate mongoTemplate;

	@Override
	public List<StockQuiz> getRandomStockQuiz() {
		Aggregation aggregation = Aggregation.newAggregation(sample(5));
		AggregationResults<StockQuiz> results = mongoTemplate.aggregate(aggregation,
				"stock_quiz", StockQuiz.class);
		return results.getMappedResults();
	}
}
