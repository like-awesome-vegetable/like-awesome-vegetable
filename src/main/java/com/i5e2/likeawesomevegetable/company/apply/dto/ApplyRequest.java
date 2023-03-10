package com.i5e2.likeawesomevegetable.company.apply.dto;

import com.i5e2.likeawesomevegetable.company.apply.Apply;
import com.i5e2.likeawesomevegetable.company.buying.CompanyBuying;
import com.i5e2.likeawesomevegetable.user.basic.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplyRequest {

    private Long applyQuantity;

    public Apply toEntity(Long applyQuantity, CompanyBuying companyBuying, User user) {
        return Apply.builder()
                .companyBuying(companyBuying)
                .participationStatus(companyBuying.getParticipationStatus())
                .applyQuantity(applyQuantity)
                .buyingTitle(companyBuying.getBuyingTitle())
                .user(user)
                .build();
    }
}