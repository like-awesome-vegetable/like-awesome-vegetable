package com.i5e2.likeawesomevegetable.domain.verification.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SendEmailCodeRequest {
    private String email;
}
