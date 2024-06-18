package ScreeningHumanity.MemberMypageServer.subscribe.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class KafkaInputVo {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ChangeNickName {
        private String beforeNickName;
        private String afterNickName;
    }
}
