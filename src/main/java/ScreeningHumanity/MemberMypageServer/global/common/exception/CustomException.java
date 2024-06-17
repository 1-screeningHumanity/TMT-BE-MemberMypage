package ScreeningHumanity.MemberMypageServer.global.common.exception;

import ScreeningHumanity.MemberMypageServer.global.common.response.BaseResponseCode;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private final BaseResponseCode status;

    public CustomException(BaseResponseCode status) {
        this.status = status;
    }
}