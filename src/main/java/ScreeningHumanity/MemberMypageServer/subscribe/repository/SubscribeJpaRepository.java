package ScreeningHumanity.MemberMypageServer.subscribe.repository;

import ScreeningHumanity.MemberMypageServer.subscribe.entity.SubscribeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscribeJpaRepository extends JpaRepository<SubscribeEntity, Long> {

    Boolean existsBySubscriberUuidAndSubscribedToNickName(String subscriberUuid, String subscribedToNickName);
}
