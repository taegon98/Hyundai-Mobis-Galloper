package com.server.api.dto.ardu;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FingerPrintRequest {
    @NotBlank(message="필수 값 입니다.")
    private int fid;
}
