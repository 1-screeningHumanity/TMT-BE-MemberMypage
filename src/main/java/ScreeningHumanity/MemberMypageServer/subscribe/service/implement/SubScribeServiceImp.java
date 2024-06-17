package ScreeningHumanity.MemberMypageServer.subscribe.service.implement;

import ScreeningHumanity.MemberMypageServer.global.common.exception.CustomException;
import ScreeningHumanity.MemberMypageServer.global.common.kafka.KafkaProducer;
import ScreeningHumanity.MemberMypageServer.global.common.response.BaseResponseCode;
import ScreeningHumanity.MemberMypageServer.subscribe.dto.KafkaMessageDto;
import ScreeningHumanity.MemberMypageServer.subscribe.dto.SubscribeDto;
import ScreeningHumanity.MemberMypageServer.subscribe.entity.SubscribeEntity;
import ScreeningHumanity.MemberMypageServer.subscribe.entity.SubscribeStatus;
import ScreeningHumanity.MemberMypageServer.subscribe.repository.SubscribeJpaRepository;
import ScreeningHumanity.MemberMypageServer.subscribe.service.SubscribeService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SubScribeServiceImp implements SubscribeService {

    private final SubscribeJpaRepository subscribeJpaRepository;
    private final KafkaProducer kafkaProducer;

    @Transactional
    @Override
    public void createNewSubscribe(String uuid, SubscribeDto.Create requestDto) {
        //이미 있는지 조회 필요.
        //있을경우 throw exception
        if(Boolean.FALSE == subscribeJpaRepository.existsBySubscriberUuidAndSubscribedToNickName(
                uuid,
                requestDto.getNickName())){
            throw new CustomException(BaseResponseCode.ALREADY_EXIST_SUBSCRIBE_MEMBER);
        }

        //cash 조회 API 호출 필요.
        //비교하는 값은 requestDto 에서 추출해서 쓰면됨.
        //todo:
//        throw new CustomException(BaseResponseCode.NOT_ENOUGH_MEMBER_CASH);

        //create new
        SubscribeEntity savedData = subscribeJpaRepository.save(
                SubscribeEntity
                        .builder()
                        .subscriberUuid(uuid)
                        .subscribedToNickName(requestDto.getNickName())
                        .status(SubscribeStatus.SUBSCRIBE)
                        .build()
        );

        try {
            SendResult<String, String> stringStringSendResult = kafkaProducer.send(
                    "subscribe-payment-changecash",
                    KafkaMessageDto.UseCash
                            .builder()
                            .uuid(uuid)
                            .cash(requestDto.getCash())
                            .build()
            ).get();
        } catch (Exception e){
            subscribeJpaRepository.deleteById(savedData.getId());
            throw new CustomException(BaseResponseCode.CREATE_NEW_SUBSCRIBE_ERROR);
        }
    }
}
