package ScreeningHumanity.MemberMypageServer.subscribe.vo.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class KafkaOutVo {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class UseCash {
        private String uuid;
        private Long cash;
    }
}
