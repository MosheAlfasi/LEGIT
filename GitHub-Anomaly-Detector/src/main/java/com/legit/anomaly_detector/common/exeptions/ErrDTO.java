package com.legit.anomaly_detector.common.exeptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrDTO {
    private String areaName;
    private String errMsg;
}
