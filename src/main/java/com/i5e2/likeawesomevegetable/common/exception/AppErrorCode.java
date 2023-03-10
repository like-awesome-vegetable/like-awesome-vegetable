package com.i5e2.likeawesomevegetable.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum AppErrorCode {

    // Payment
    INVOICE_AMOUNT_MISMATCH(HttpStatus.NOT_FOUND, "인보이스 금액, 요청 금액이 불일치 합니다."),
    NO_PAYMENT_ORDER_RESULT(HttpStatus.NOT_FOUND, "사용자 결제 요청 정보가 존재하지 않습니다."),
    REFUND_AMOUNT_ERROR(HttpStatus.FORBIDDEN, "환불 요청 금액을 확인해 주세요."),
    INVALID_PERMISSION(HttpStatus.UNAUTHORIZED, "사용자가 권한이 없습니다."),
    FAIL_PAYMENT_RESPONSE(HttpStatus.FORBIDDEN, "사용자 결제 요청이 실패되었습니다."),
    NOT_FOUND_TARGET_USER(HttpStatus.NOT_FOUND, "정산 받을 유저를 확인해 주세요"),

    // Point
    NO_POINT_RESULT(HttpStatus.NOT_FOUND, "사용자 포인트 정보가 존재하지 않습니다."),
    EMPTY_POINT_RESULT(HttpStatus.NO_CONTENT, "사용자 포인트 잔액이 비어있습니다."),

    // Deposit
    NO_POINT_DEPOSIT_RESULT(HttpStatus.NOT_FOUND, "사용자의 보증금 정보가 존재하지 않습니다."),
    DIPOSIT_AMOUNT_ERROR(HttpStatus.FORBIDDEN, "포인트가 부족합니다. 보증금 요청 금액을 확인해 주세요."),
    INVALID_REQUEST_DEPOSIT(HttpStatus.BAD_REQUEST, "보증금은 현재 포인트 잔액을 초과할 수 없습니다"),

    //item
    ITEM_CODE_NOT_FOUND(HttpStatus.NOT_FOUND, "요청하신 농산물 품목 코드가 존재하지 않습니다."),

    // Verification ErrorCode
    INVALID_URL(HttpStatus.INTERNAL_SERVER_ERROR, "유효하지 않은 URL입니다."),
    VERIFICATION_DISABLE(HttpStatus.NOT_FOUND, "인증을 수행할 수 없습니다. 다시 신청해주세요."),

    // 기업/농가 파일 업로드 ErrorCode
    FARM_IMAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 농가 회원의 이미지를 찾을 수 없습니다."),
    FARM_FILE_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 농가 회원의 파일을 찾을 수 없습니다."),
    COMPANY_IMAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 기업 회원의 이미지를 찾을 수 없습니다."),
    COMPANY_FILE_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 기업 회원의 파일을 찾을 수 없습니다."),
    FILE_NOT_EXISTS(HttpStatus.BAD_REQUEST, "보낼 파일이 비어있습니다."),
    FILE_SIZE_EXCEED(HttpStatus.BAD_REQUEST, "파일 업로드 용량을 초과했습니다."),
    COMPANY_USER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 ID의 기업 정회원은 없습니다."),
    FARM_USER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 ID의 농가 정회원은 없습니다."),
    LOGIN_USER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 Email로 회원가입 된 회원은 없습니다."),

    // Message ErrorCode
    MESSAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 번호의 쪽지가 없습니다."),
    GET_MESSAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "수신한 쪽지가 없습니다."),
    SEND_MESSAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "송신한 쪽지가 없습니다."),
    INVALID_GETTER(HttpStatus.CONFLICT, "수신 대상이 올바르지 않습니다."),

    // DB
    DATABASE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "DB에러"),

    // USER
    DUPLICATED_EMAIL(HttpStatus.CONFLICT, "해당 이메일은 이미 사용중입니다."),
    EMAIL_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 이메일은 존재하지 않습니다."),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "패스워드가 잘못되었습니다."),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "잘못된 토큰입니다."),
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "만료된 토큰입니다."),
    TOKEN_NOT_FOUND(HttpStatus.UNAUTHORIZED, "토큰이 존재하지 않습니다."),
    NEED_LOGIN(HttpStatus.UNAUTHORIZED, "로그아웃 된 토큰입니다."),

    // APPLY, BIDDING
    AUTHENTICATION_FAILED(HttpStatus.UNAUTHORIZED, "본인인증에 실패하였습니다."),
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "게시글을 찾을 수 없습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 사용자입니다."),
    PHONE_DISCORD(HttpStatus.UNAUTHORIZED, "사용자의 휴대폰 번호와 불일치합니다."),
    QUANTITY_EXCEED(HttpStatus.UNAUTHORIZED, "모집 수량을 초과하였습니다."),

    // MAP
    COMPANY_ADDRESS_NOT_FOUND(HttpStatus.NOT_FOUND, "기업 주소가 존재하지않습니다."),
    FARM_ADDRESS_NOT_FOUND(HttpStatus.NOT_FOUND, "농가 주소가 존재하지않습니다."),

    // contract
    CONTRACT_NOT_FOUND(HttpStatus.NOT_FOUND, "계약서를 찾을 수 없습니다."),
    APPLY_NOT_FOUND(HttpStatus.NOT_FOUND, "모집 참여 기록을 찾을 수 없습니다."),
    BIDDING_NOT_FOUND(HttpStatus.NOT_FOUND, "경매 입찰 기록을 찾을 수 없습니다."),
    ITEM_NOT_FOUND(HttpStatus.NOT_FOUND, "아이템 정보가 없습니다. DB 업데이트 필요");

    private HttpStatus status;
    private String message;

}
