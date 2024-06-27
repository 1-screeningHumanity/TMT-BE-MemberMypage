package ScreeningHumanity.MemberMypageServer.readonly.ranking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "asset_ranking")
public class AssetRanking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asset_ranking_id")
    private Long assetRankingId;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "ranking")
    private Long ranking;

    @Column(name = "yesterday_ranking")
    private Long yesterdayRanking;

    @Column(name = "change_ranking")
    private Long changeRanking;

    @Column(name = "won")
    private Long won;
}