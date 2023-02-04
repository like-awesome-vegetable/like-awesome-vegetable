package com.i5e2.likeawesomevegetable.domain.verification.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum VerificationErrorCode {
    INVALID_URL(HttpStatus.INTERNAL_SERVER_ERROR, "유효하지 않은 URL입니다."),
    VERIFICATION_DISABLE(HttpStatus.NOT_FOUND, "인증을 수행할 수 없습니다. 다시 신청해주세요.");

    private final HttpStatus status;
    private final String message;
}
