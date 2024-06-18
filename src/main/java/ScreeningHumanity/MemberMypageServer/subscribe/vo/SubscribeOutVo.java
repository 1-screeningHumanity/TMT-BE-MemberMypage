package ScreeningHumanity.MemberMypageServer.subscribe.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class SubscribeOutVo {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class IsSubscribe {
        private Boolean isSubscribe;
    }
}
