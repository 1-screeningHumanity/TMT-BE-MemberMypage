package ScreeningHumanity.MemberMypageServer.quiz.presentation;

import ScreeningHumanity.MemberMypageServer.global.common.response.BaseResponse;
import ScreeningHumanity.MemberMypageServer.quiz.application.StockQuizService;
import ScreeningHumanity.MemberMypageServer.quiz.vo.out.StockQuizVo;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StockQuizController {

	private final StockQuizService stockQuizService;

	@GetMapping("/quiz")
	public BaseResponse<List<StockQuizVo>> getStockQuiz() {
		return new BaseResponse<>(StockQuizVo.getStockQuizDto(stockQuizService.getStockQuiz()));
	}
}
