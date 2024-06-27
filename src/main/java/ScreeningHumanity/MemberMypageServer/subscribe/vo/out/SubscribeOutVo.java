package ScreeningHumanity.MemberMypageServer.subscribe.vo.out;

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

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Follower {

        private Long id;
        private String nickName;
        private Long ranking;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Following {

        private Long id;
        private String nickName;
    }
}
