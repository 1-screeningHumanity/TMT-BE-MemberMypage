package ScreeningHumanity.MemberMypageServer.subscribe.service;

import ScreeningHumanity.MemberMypageServer.subscribe.dto.SubscribeDto;

public interface SubscribeService {

    void createNewSubscribe(String uuid, SubscribeDto.Create requestDto);
}
