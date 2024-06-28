package ScreeningHumanity.MemberMypageServer.quiz.application;

import ScreeningHumanity.MemberMypageServer.quiz.dto.in.StockQuizDto;
import ScreeningHumanity.MemberMypageServer.quiz.infrastructure.StockQuizRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockQuizServiceImp implements StockQuizService{

	private final StockQuizRepository stockQuizRepository;

	@Override
	public List<StockQuizDto> getStockQuiz() {
		return StockQuizDto.getStockQuiz(stockQuizRepository.getRandomStockQuiz());
	}

}
