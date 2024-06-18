package ScreeningHumanity.MemberMypageServer.global.common.kafka;

import ScreeningHumanity.MemberMypageServer.subscribe.service.KafkaConsumerService;
import ScreeningHumanity.MemberMypageServer.subscribe.vo.KafkaInputVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    private final KafkaConsumerService kafkaConsumerService;

    @KafkaListener(topics="member-subscribe-changenickname")
    public void reservationStock(String kafkaMessage){
        log.info("kafka Message : {}", kafkaMessage);

        KafkaInputVo.ChangeNickName vo = new KafkaInputVo.ChangeNickName();
        ObjectMapper mapper = new ObjectMapper();
        try{
            vo = mapper.readValue(kafkaMessage, new TypeReference<>() {});
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }

        kafkaConsumerService.changeNickName(vo);
    }
}
