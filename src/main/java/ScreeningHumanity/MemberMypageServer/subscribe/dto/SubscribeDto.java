package ScreeningHumanity.MemberMypageServer.subscribe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class SubscribeDto {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private String nickName;
        private Long cash;
    }
}
