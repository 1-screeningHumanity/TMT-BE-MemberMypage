package ScreeningHumanity.MemberMypageServer.subscribe.repository;

import ScreeningHumanity.MemberMypageServer.subscribe.entity.SubscribeEntity;
import ScreeningHumanity.MemberMypageServer.subscribe.entity.SubscribeStatus;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubscribeJpaRepository extends JpaRepository<SubscribeEntity, Long> {

    Boolean existsBySubscriberUuidAndSubscribedNickNameAndStatus(String subscriberUuid,
            String subscribedNickName, SubscribeStatus status);

    Optional<SubscribeEntity> findBySubscriberUuidAndSubscribedNickNameAndStatus(
            String subscriberUuid, String subscribedNickName, SubscribeStatus status);

    @Modifying
    @Query("UPDATE SubscribeEntity s SET s.status = :status WHERE s.subscriberUuid = :uuid AND s.subscribedNickName = :nickName AND s.status != :status")
    int updateSubscribeStatus(@Param("uuid") String uuid, @Param("nickName") String nickName,
            @Param("status") SubscribeStatus status);

    @Modifying
    @Query("UPDATE SubscribeEntity s SET s.subscribedNickName = :afterNickName, s.modifiedAt = :modifiedAt WHERE s.subscribedNickName = :beforeNickName")
    void updateSubscribedNickName(@Param("beforeNickName") String beforeNickName,
            @Param("afterNickName") String afterNickName,
            @Param("modifiedAt") LocalDateTime modifiedAt);

    @Modifying
    @Query("UPDATE SubscribeEntity s SET s.subscriberNickName = :afterNickName, s.modifiedAt = :modifiedAt WHERE s.subscriberNickName = :beforeNickName")
    void updateSubscriberNickName(@Param("beforeNickName") String beforeNickName,
            @Param("afterNickName") String afterNickName,
            @Param("modifiedAt") LocalDateTime modifiedAt);

    List<SubscribeEntity> findAllBySubscribedNickNameAndStatus(String subscribedNickName,
            SubscribeStatus status);

    List<SubscribeEntity> findAllBySubscriberNickNameAndStatus(String subscriberNickName,
            SubscribeStatus status);
}
