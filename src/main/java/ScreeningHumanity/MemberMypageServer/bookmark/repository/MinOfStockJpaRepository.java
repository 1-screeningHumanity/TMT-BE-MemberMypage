package ScreeningHumanity.MemberMypageServer.bookmark.repository;

import ScreeningHumanity.MemberMypageServer.bookmark.entity.MinOfStockEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinOfStockJpaRepository extends MongoRepository<MinOfStockEntity, String> {

    @Query("{ 'stockCode': { '$in': ?0 } }")
    List<MinOfStockEntity> findByStockCodeIn(List<String> stockCodes);
}
