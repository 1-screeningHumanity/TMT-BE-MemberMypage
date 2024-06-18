package ScreeningHumanity.MemberMypageServer.subscribe.service;

import ScreeningHumanity.MemberMypageServer.subscribe.vo.KafkaInputVo;

public interface KafkaConsumerService {

    void changeNickName(KafkaInputVo.ChangeNickName vo);
}
