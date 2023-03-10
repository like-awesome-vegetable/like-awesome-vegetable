package com.i5e2.likeawesomevegetable.farm.bidding.repository;

import com.i5e2.likeawesomevegetable.farm.bidding.Standby;
import com.i5e2.likeawesomevegetable.farm.bidding.dto.BiddingMaxResponse;
import com.i5e2.likeawesomevegetable.user.basic.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StandByJpaRepository extends JpaRepository<Standby, Long> {
    Page<Standby> findAllByFarmAuctionId(Long id, Pageable pageable);

    Page<Standby> findByUser(User user, Pageable pageable);

    Standby findByUserId(Long userId);

    boolean existsByFarmAuctionId(Long auctionId);

    @Query(value = "select max(bidding_price) as price, " +
            "       standBy.user_id as userId " +
            "from t_standby as standBy " +
            "group by farm_auction_id = ? ", nativeQuery = true)
    BiddingMaxResponse findByFarmAuctionId(@Param("farmAuctionId") Long farmAuctionId);

    List<Standby> findAllByFarmAuctionId(Long auctionId);

    @Query(value = "select standBy.user " +
            "from Standby as standBy " +
            "where standBy.farmAuction.id = :farmAuctionId ")
    List<User> selectByFarmAuctionId(@Param("farmAuctionId") Long farmAuctionId);
}
