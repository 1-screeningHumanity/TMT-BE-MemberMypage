package ScreeningHumanity.MemberMypageServer.subscribe.service.implement;

import ScreeningHumanity.MemberMypageServer.subscribe.repository.SubscribeJpaRepository;
import ScreeningHumanity.MemberMypageServer.subscribe.service.KafkaConsumerService;
import ScreeningHumanity.MemberMypageServer.subscribe.vo.in.KafkaInVo;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class KafkaConsumerServiceImp implements KafkaConsumerService {

    private final SubscribeJpaRepository subscribeJpaRepository;

    @Transactional
    @Override
    public void changeNickName(KafkaInVo.ChangeNickName vo) {
        subscribeJpaRepository.updateSubscribedToNickName(
                vo.getBeforeNickName(),
                vo.getAfterNickName(),
                LocalDateTime.now()
        );

        //todo : 닉네임 변경에 실패할 경우가 있을까? 또, 이때 트랜잭션 관리를 어떻게 진행 해줘야할까?
    }
}
