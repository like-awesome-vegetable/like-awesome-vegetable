package com.i5e2.likeawesomevegetable.company.buying.dto;

import com.i5e2.likeawesomevegetable.board.post.dto.ParticipationStatus;
import com.i5e2.likeawesomevegetable.board.post.dto.PostPointActivateEnum;
import com.i5e2.likeawesomevegetable.company.buying.CompanyBuying;
import com.i5e2.likeawesomevegetable.user.company.CompanyUser;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuyingRequest {

    @NotBlank(message = "제목을 입력해 주세요")
    private String title;
    @NotBlank(message = "시작날짜를 달력에서 선택해 주세요")
    private String startTime;
    @NotBlank(message = "종료날짜를 달력에서 선택해 주세요")
    private String endTime;
    @Min(value = 0, message = "카테고리를 선택해 주세요")
    private String category;
    @NotBlank(message = "품종을 선택해 주세요")
    private String item;
    @NotNull(message = "수량을 입력해 주세요")
    @Min(value = 3, message = "3t이상 모집이 가능합니다.")
    @Positive(message = "숫자만 입력해 주세요.")
    private Integer quantity;
    @NotNull(message = "가격을 입력해 주세요")
    @Min(value = 0, message = "정확한 가격을 입력해 주세요")
    private Integer price;
    @NotBlank(message = "내용을 입력해 주세요")
    private String description;
    @Min(value = 1, message = "운임 방법을 선택해 주세요")
    private int shipping; //int -> string으로 변환
    @NotBlank(message = "수령인을 입력해 주세요")
    private String receiverName;
    @NotBlank(message = "수령인의 연락처를 입력해 주세요")
    private String receiverPhoneNo;
    @NotBlank(message = "배송 받을 주소를 입력해 주세요")
    private String receiverAddress;

    public CompanyBuying toEntity(BuyingRequest buyingRequest, CompanyUser companyUser) {
        return CompanyBuying.builder()
                .buyingTitle(buyingRequest.getTitle())
                .buyingStartTime(buyingRequest.getStartTime())
                .buyingEndTime(buyingRequest.getEndTime())
                .buyingItemCategory(buyingRequest.getCategory())
                .buyingItem(buyingRequest.getItem())
                .buyingQuantity(buyingRequest.getQuantity())
                .buyingPrice(buyingRequest.getPrice())
                .buyingDescription(buyingRequest.getDescription())
                .buyingShipping(shippingConvert(buyingRequest.getShipping())) //int->string
                .receiverName(buyingRequest.getReceiverName())
                .receiverPhoneNo(buyingRequest.getReceiverPhoneNo())
                .receiverAddress(buyingRequest.getReceiverAddress())
                .companyUser(companyUser)
                .participationStatus(ParticipationStatus.valueOf(status(buyingRequest.getStartTime())))
                .postPointActivate(PostPointActivateEnum.DISABLED)
//                .buyingRegisteredAt
//                .buyingModifiedAt
//                .buyingDeletedAt
                .build();
    }

    private String shippingConvert(int value) {
        if (value == 1) {
            return "BOXING";
        } else if (value == 2) {
            return "TONBAG";
        } else if (value == 3) {
            return "CONTIBOX";
        }
        return "0";
    }

    private String status(String startTime) {
        String[] arrToday = LocalDateTime.now().toString().substring(0, 10).split("-");
        int today = Integer.parseInt(arrToday[0] + arrToday[1] + arrToday[2]);

        String[] arrRegisteredAt = startTime.substring(0, 10).split("-");
        int intRegisteredAt = Integer.parseInt(arrRegisteredAt[0] + arrRegisteredAt[1] + arrRegisteredAt[2]);

        if (today >= intRegisteredAt) {
            return "UNDERWAY";
        } else {
            return "BEFORE";
        }

    }

}
