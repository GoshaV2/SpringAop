package com.example.springaop.tracker.time.controller.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MethodDurationAnalyticResponse {
    private String methodName;
    private String methodTargetClass;
    private String signature;
    private double averageDuration;
    private long maxDuration;
    private long minDuration;
}
