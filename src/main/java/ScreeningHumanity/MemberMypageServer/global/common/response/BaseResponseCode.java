package ScreeningHumanity.MemberMypageServer.global.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * 식별 코드 범위
 * 성공 : 200(통일)
 * 유저 에러 : 1000~1999
 * 매수/매도 에러 : 2000~2999
 * 랭킹 에러 : 3000~3999
 * 알림 : 4000~4999
 * 추가 기능 에러 :
 *      북마크 : 5000~5099
 *      구독 : 5100~5199
 *      {추가기능 발생 시} : 5200~5299
 * 차트 에러 : 6000~6999
 * 공통 에러 : 9000~9999
 */
@Getter
@RequiredArgsConstructor
public enum BaseResponseCode {
    // Success
    SUCCESS(HttpStatus.OK, true, 200, "요청 응답 성공"),
    UPDATE_SUBSCRIBE_SUCCESS(HttpStatus.OK, true, 201, "이전에 구독한 회원은 추가 결제 되지 않습니다."),

    // 구독 서비스
    ALREADY_EXIST_SUBSCRIBE_MEMBER_ERROR(HttpStatus.BAD_REQUEST, false, 5100, "이미 구독한 회원입니다."),
    SEARCH_MEMBER_CASH_ERROR(HttpStatus.BAD_REQUEST, false, 5101, "회원의 보유중인 캐시가 부족합니다."),
    NOT_ENOUGH_MEMBER_CASH_ERROR(HttpStatus.BAD_REQUEST, false, 5102, "회원의 보유중인 캐시가 부족합니다."),
    CREATE_NEW_SUBSCRIBE_ERROR(HttpStatus.BAD_REQUEST, false, 5103, "회원 구독 중, 서버 에러가 발생 했습니다. 다시 시도 해 주세요."),

    NOT_EXIST_SUBSCRIBE_INFO_ERROR(HttpStatus.BAD_REQUEST, false, 5104, "구독중인 회원이 아닙니다."),

    //공통 에러. 9000 ~ 9999
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, false, 9000, "서버 에러"),
    VALIDATION_FAIL_ERROR(HttpStatus.BAD_REQUEST, false, 9100, "(exception error 메세지에 따름)"),
    PATH_VARIABLE_ERROR(HttpStatus.BAD_REQUEST, false, 9200, "잘못된 Path Variable 입력"),
    REQUEST_PARAM_ERROR(HttpStatus.BAD_REQUEST, false, 9300, "잘못된 Request Parameter 입력"),
    NO_HANDLER_FOUND_ERROR(HttpStatus.BAD_REQUEST, false, 9400, "존재 하지 않는 END-POINT"),
    METHOD_NOT_ALLOW_ERROR(HttpStatus.METHOD_NOT_ALLOWED, false, 9500, "(exception error 메세지에 따름)"),
    TOKEN_IS_EXPIRED_ERROR(HttpStatus.UNAUTHORIZED, false, 9999, "(gateway 에서 error 처리)");

    private final HttpStatus httpStatus;
    private final boolean isSuccess;
    private final int code;
    private final String message;
}
