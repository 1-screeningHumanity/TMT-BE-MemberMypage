package ScreeningHumanity.MemberMypageServer.subscribe.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class SubscribeVo {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private String nickName;
        private Long cash;
    }
}
