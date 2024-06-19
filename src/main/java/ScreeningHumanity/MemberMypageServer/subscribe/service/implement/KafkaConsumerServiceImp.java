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
        subscribeJpaRepository.updateSubscribedNickName(
                vo.getBeforeNickName(),
                vo.getAfterNickName(),
                LocalDateTime.now()
        );

        subscribeJpaRepository.updateSubscriberNickName(
                vo.getBeforeNickName(),
                vo.getAfterNickName(),
                LocalDateTime.now()
        );
    }
}
