package ScreeningHumanity.MemberMypageServer.global.common.feignclinet.vo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentGetCashVo {
    @NotNull
    private Long cash;
}
