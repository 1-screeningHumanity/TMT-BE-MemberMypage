package ScreeningHumanity.MemberMypageServer.subscribe.controller;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import ScreeningHumanity.MemberMypageServer.global.common.response.BaseResponse;
import ScreeningHumanity.MemberMypageServer.global.common.response.BaseResponseCode;
import ScreeningHumanity.MemberMypageServer.global.common.token.DecodingToken;
import ScreeningHumanity.MemberMypageServer.subscribe.dto.SubscribeDto;
import ScreeningHumanity.MemberMypageServer.subscribe.service.SubscribeService;
import ScreeningHumanity.MemberMypageServer.subscribe.vo.out.SubscribeOutVo;
import ScreeningHumanity.MemberMypageServer.subscribe.vo.in.SubscribeInVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Subscribe API", description = "회원 구독 관련 API")
public class SubscribeController {

    private final SubscribeService subscribeService;
    private final ModelMapper modelMapper;
    private final DecodingToken decodingToken;

    @Operation(summary = "회원 구독 api", description = "타 회원을 구독 합니다.")
    @PostMapping("/subscribe")
    private BaseResponse<Void> subscribeMember(
            @RequestBody SubscribeInVo.Create requestVo,
            @RequestHeader(AUTHORIZATION) String accessToken
    ){
        BaseResponseCode status = subscribeService.createNewSubscribe(
                decodingToken.getUuid(accessToken),
                modelMapper.map(requestVo, SubscribeDto.Create.class),
                accessToken
        );

        return new BaseResponse<>(status);
    }

    @Operation(summary = "회원 구독 취소 api", description = "타 회원을 구독을 취소 합니다.")
    @DeleteMapping("/subscribe")
    private BaseResponse<Void> deleteSubscribeMember(
            @RequestBody SubscribeInVo.Delete requestVo,
            @RequestHeader(AUTHORIZATION) String accessToken
    ){
        subscribeService.deleteSubscribe(
                decodingToken.getUuid(accessToken),
                modelMapper.map(requestVo, SubscribeDto.Delete.class)
        );

        return new BaseResponse<>();
    }

    @Operation(summary = "회원 구독 여부 조회 api", description = "타 회원을 구독여부를 확인 합니다.")
    @GetMapping("/subscribe")
    private BaseResponse<SubscribeOutVo.IsSubscribe> isSubscribeMember(
            @RequestParam("nickName") String nickName,
            @RequestHeader(AUTHORIZATION) String accessToken
    ){
        SubscribeOutVo.IsSubscribe findData = subscribeService.isSubscribeMember(
                decodingToken.getUuid(accessToken),
                nickName
        );

        return new BaseResponse<>(findData);
    }
}
