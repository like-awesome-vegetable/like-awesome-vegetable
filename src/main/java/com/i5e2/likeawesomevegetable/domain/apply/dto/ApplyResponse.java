package com.i5e2.likeawesomevegetable.domain.apply.dto;

import com.i5e2.likeawesomevegetable.domain.apply.Apply;
import com.i5e2.likeawesomevegetable.domain.apply.ComapnyBuyingStatus;
import com.i5e2.likeawesomevegetable.domain.market.CompanyBuying;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplyResponse {

    private Long applyQuantity;
    private Long companyBuyingId;
    private Long userId;
    private ComapnyBuyingStatus companyBuyingStatus;
    private CompanyBuying companyBuying;
    private String buyingTitle;
    private String applyNumber;

    public static ApplyResponse fromEntity(Apply savedApply) {
        return ApplyResponse.builder()
                .applyQuantity(savedApply.getApplyQuantity())
                .companyBuying(savedApply.getCompanyBuying())
                .companyBuyingStatus(savedApply.getCompanyBuyingStatus())
                .buyingTitle(savedApply.getBuyingTitle())
                .applyNumber(savedApply.getApplyNumber())
                .companyBuyingId(savedApply.getCompanyBuying().getId())
                .userId(savedApply.getUser().getId())
                .build();
    }
}