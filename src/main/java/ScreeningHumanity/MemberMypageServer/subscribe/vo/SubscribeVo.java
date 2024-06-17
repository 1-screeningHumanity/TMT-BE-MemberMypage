package ScreeningHumanity.MemberMypageServer.subscribe.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class SubscribeVo {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Create {
        private String nickName;
        private String cash;
    }
}
