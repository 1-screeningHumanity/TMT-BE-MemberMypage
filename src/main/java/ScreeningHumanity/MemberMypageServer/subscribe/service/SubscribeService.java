package ScreeningHumanity.MemberMypageServer.subscribe.service;

import ScreeningHumanity.MemberMypageServer.global.common.response.BaseResponseCode;
import ScreeningHumanity.MemberMypageServer.subscribe.dto.SubscribeDto;

public interface SubscribeService {

    BaseResponseCode createNewSubscribe(String uuid, SubscribeDto.Create requestDto, String accessToken);

    void deleteSubscribe(String uuid, SubscribeDto.Delete requestDto);
}
