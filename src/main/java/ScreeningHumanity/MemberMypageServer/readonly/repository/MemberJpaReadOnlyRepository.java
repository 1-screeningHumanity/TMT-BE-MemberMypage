package ScreeningHumanity.MemberMypageServer.readonly.repository;

import ScreeningHumanity.MemberMypageServer.readonly.entity.MemberEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaReadOnlyRepository extends JpaRepository<MemberEntity, Long> {

    Optional<MemberEntity> findAllByNickname(String nickname);
}
