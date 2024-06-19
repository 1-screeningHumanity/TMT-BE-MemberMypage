package ScreeningHumanity.MemberMypageServer.subscribe.service;

import ScreeningHumanity.MemberMypageServer.global.common.response.BaseResponseCode;
import ScreeningHumanity.MemberMypageServer.subscribe.dto.SubscribeDto;
import ScreeningHumanity.MemberMypageServer.subscribe.vo.out.SubscribeOutVo;
import java.util.List;

public interface SubscribeService {

    BaseResponseCode createNewSubscribe(String uuid, SubscribeDto.Create requestDto, String accessToken);

    void deleteSubscribe(String uuid, SubscribeDto.Delete requestDto);

    SubscribeOutVo.IsSubscribe isSubscribeMember(String uuid, String nickName);

    List<SubscribeOutVo.Follower> searchFollower(String myNickName);
}
