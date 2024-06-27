package ScreeningHumanity.MemberMypageServer.readonly.repository;

import ScreeningHumanity.MemberMypageServer.readonly.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaReadOnlyRepository extends JpaRepository<MemberEntity, Long> {

}
