package ScreeningHumanity.MemberMypageServer.subscribe.service.implement;

import ScreeningHumanity.MemberMypageServer.global.common.exception.CustomException;
import ScreeningHumanity.MemberMypageServer.global.common.feignclinet.ProviderCallFeignClient;
import ScreeningHumanity.MemberMypageServer.global.common.feignclinet.vo.PaymentGetCashVo;
import ScreeningHumanity.MemberMypageServer.global.common.kafka.KafkaProducer;
import ScreeningHumanity.MemberMypageServer.global.common.response.BaseResponse;
import ScreeningHumanity.MemberMypageServer.global.common.response.BaseResponseCode;
import ScreeningHumanity.MemberMypageServer.subscribe.dto.KafkaMessageDto;
import ScreeningHumanity.MemberMypageServer.subscribe.dto.SubscribeDto;
import ScreeningHumanity.MemberMypageServer.subscribe.entity.SubscribeEntity;
import ScreeningHumanity.MemberMypageServer.subscribe.entity.SubscribeStatus;
import ScreeningHumanity.MemberMypageServer.subscribe.repository.SubscribeJpaRepository;
import ScreeningHumanity.MemberMypageServer.subscribe.service.SubscribeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubScribeServiceImp implements SubscribeService {

    private final SubscribeJpaRepository subscribeJpaRepository;
    private final KafkaProducer kafkaProducer;
    private final ProviderCallFeignClient providerCallFeignClient;

    @Transactional
    @Override
    public void createNewSubscribe(String uuid, SubscribeDto.Create requestDto,
            String accessToken) {

        if (Boolean.TRUE == subscribeJpaRepository.existsBySubscriberUuidAndSubscribedToNickName(
                uuid,
                requestDto.getNickName())) {
            throw new CustomException(BaseResponseCode.ALREADY_EXIST_SUBSCRIBE_MEMBER_ERROR);
        }

        BaseResponse<PaymentGetCashVo> response;
        try {
            response = providerCallFeignClient.searchMemberCash(accessToken);
        } catch (Exception e) {
            throw new CustomException(BaseResponseCode.SEARCH_MEMBER_CASH_ERROR);
        }

        if (response.result().getCash() < requestDto.getCash()) {
            throw new CustomException(BaseResponseCode.NOT_ENOUGH_MEMBER_CASH_ERROR);
        }

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
        } catch (Exception e) {
            subscribeJpaRepository.deleteById(savedData.getId());
            throw new CustomException(BaseResponseCode.CREATE_NEW_SUBSCRIBE_ERROR);
        }
    }
}
