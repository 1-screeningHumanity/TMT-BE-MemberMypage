package ScreeningHumanity.MemberMypageServer.readonly.ranking.repository;

import ScreeningHumanity.MemberMypageServer.readonly.ranking.entity.AssetRanking;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AssetRankingJpaReadOnlyRepository extends JpaRepository<AssetRanking, Long> {

    @Query("SELECT a FROM AssetRanking a WHERE a.nickname IN :nicknames")
    List<AssetRanking> findRankingsByNicknameIn(@Param("nicknames") List<String> nicknames);
}
