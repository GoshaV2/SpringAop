package com.example.springaop.tracker.time.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class MethodDurationAnalyticListResponse {
    private List<MethodDurationAnalyticResponse> methodDurationAnalytics;
    private boolean hasNext;
    private int size;
}
