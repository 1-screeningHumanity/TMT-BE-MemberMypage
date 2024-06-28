package ScreeningHumanity.MemberMypageServer.quiz.vo.out;

import ScreeningHumanity.MemberMypageServer.quiz.dto.in.StockQuizDto;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StockQuizVo {

	private String question;
	private String answer;
	private String comment;

	public static List<StockQuizVo> getStockQuizDto(List<StockQuizDto> dtos) {
		return dtos.stream()
				.map(dto -> StockQuizVo.builder()
						.question(dto.getQuestion())
						.answer(dto.getAnswer())
						.comment(dto.getComment())
						.build()
				)
				.toList();
	}
}


