package ScreeningHumanity.MemberMypageServer.subscribe.service;

import ScreeningHumanity.MemberMypageServer.subscribe.vo.in.KafkaInVo;

public interface KafkaConsumerService {

    void changeNickName(KafkaInVo.ChangeNickName vo);
}
