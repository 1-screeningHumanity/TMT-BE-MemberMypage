package ScreeningHumanity.MemberMypageServer.subscribe.repository;

import ScreeningHumanity.MemberMypageServer.subscribe.entity.SubscribeEntity;
import ScreeningHumanity.MemberMypageServer.subscribe.entity.SubscribeStatus;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubscribeJpaRepository extends JpaRepository<SubscribeEntity, Long> {

    Boolean existsBySubscriberUuidAndSubscribedToNickNameAndStatus(String subscriberUuid, String subscribedToNickName, SubscribeStatus status);

    Optional<SubscribeEntity> findBySubscriberUuidAndSubscribedToNickName(String subscriberUuid, String subscribedToNickName);

    @Modifying
    @Query("UPDATE SubscribeEntity s SET s.status = :status WHERE s.subscriberUuid = :uuid AND s.subscribedToNickName = :nickName AND s.status != :status")
    int updateSubscribeStatus(@Param("uuid") String uuid, @Param("nickName") String nickName, @Param("status") SubscribeStatus status);
}
