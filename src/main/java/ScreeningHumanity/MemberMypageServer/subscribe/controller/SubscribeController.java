package ScreeningHumanity.MemberMypageServer.subscribe.controller;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import ScreeningHumanity.MemberMypageServer.global.common.response.BaseResponse;
import ScreeningHumanity.MemberMypageServer.global.common.token.DecodingToken;
import ScreeningHumanity.MemberMypageServer.subscribe.dto.SubscribeDto;
import ScreeningHumanity.MemberMypageServer.subscribe.service.SubscribeService;
import ScreeningHumanity.MemberMypageServer.subscribe.vo.SubscribeVo;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Subscribe API", description = "회원 구독 관련 API")
public class SubscribeController {

    private final SubscribeService subscribeService;
    private final ModelMapper modelMapper;
    private final DecodingToken decodingToken;

    @PostMapping
    private BaseResponse<Void> subscribeMember(
            @RequestBody SubscribeVo.Create requestVo,
            @RequestHeader(AUTHORIZATION) String accessToken
    ){
        subscribeService.createNewSubscribe(
                decodingToken.getUuid(accessToken),
                modelMapper.map(requestVo, SubscribeDto.Create.class)
        );

        return new BaseResponse<>();
    }
}
