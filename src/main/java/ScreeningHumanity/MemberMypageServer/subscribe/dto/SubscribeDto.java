package ScreeningHumanity.MemberMypageServer.subscribe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class SubscribeDto {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Create {
        private String nickName;
        private String cash;
    }
}
