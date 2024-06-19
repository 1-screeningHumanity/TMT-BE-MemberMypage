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

        private String subscriberNickName; //구독 하는 사람
        private String subscribedNickName; //구독 받는 사람
        private Long cash;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Delete {

        private String nickName;
    }
}
