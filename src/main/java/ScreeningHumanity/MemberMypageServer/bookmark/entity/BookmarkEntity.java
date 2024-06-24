package ScreeningHumanity.MemberMypageServer.bookmark.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bookmark")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookmarkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uuid", nullable = false)
    private String uuid;

    @Column(name = "stock_code", nullable = false)
    private String stockCode;

    @Column(name = "stock_name", nullable = false)
    private String stockName;
}
