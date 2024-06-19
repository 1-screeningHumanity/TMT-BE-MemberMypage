package ScreeningHumanity.MemberMypageServer.global.common.feignclinet;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import ScreeningHumanity.MemberMypageServer.global.common.feignclinet.vo.PaymentGetCashVo;
import ScreeningHumanity.MemberMypageServer.global.common.response.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "MyPage", url = "${FEIGN_CLIENT.PAYMENT.URL}")
public interface ProviderCallFeignClient {

    @GetMapping(value = "/cash")
    BaseResponse<PaymentGetCashVo> searchMemberCash(@RequestHeader(AUTHORIZATION) String accessToken);
}
