package com.server.api.dto.ardu;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FingerPrintRequest {
    @NotNull
    private int fid;
}
