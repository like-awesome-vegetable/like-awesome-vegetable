package com.i5e2.likeawesomevegetable.payment.deposit.repository;

import com.i5e2.likeawesomevegetable.payment.deposit.UserPointDeposit;
import com.i5e2.likeawesomevegetable.payment.deposit.dto.DepositTotalBalanceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserPointDepositJpaRepository extends JpaRepository<UserPointDeposit, Long> {
    @Query(value = "select COALESCE(sum(deposit.depositAmount), 0) as depositTotalAmount " +
            "from UserPointDeposit as deposit " +
            "where deposit.userPoint.user.id = :id")
    DepositTotalBalanceDto getDepositTotalBalance(@Param("id") Long id);

    Optional<UserPointDeposit> findByUserPointId(Long userPointId);

}

