package com.server.api.dto.ardu;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FingerPrintRequest {
    @NotNull
    private int fid;
}
