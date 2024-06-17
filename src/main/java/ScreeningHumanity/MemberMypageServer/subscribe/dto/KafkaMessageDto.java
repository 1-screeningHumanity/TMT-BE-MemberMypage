package ScreeningHumanity.MemberMypageServer.subscribe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class KafkaMessageDto {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class UseCash {
        private String uuid;
        private String cash;
    }
}
