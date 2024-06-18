package ScreeningHumanity.MemberMypageServer.subscribe.vo.in;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class KafkaInVo {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ChangeNickName {
        private String beforeNickName;
        private String afterNickName;
    }
}
