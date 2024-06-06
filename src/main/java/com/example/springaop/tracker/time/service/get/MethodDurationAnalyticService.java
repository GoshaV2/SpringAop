package com.example.springaop.tracker.time.service.get;

import com.example.springaop.tracker.time.controller.dto.response.MethodDurationAnalyticListResponse;

public interface MethodDurationAnalyticService {
    MethodDurationAnalyticListResponse getAveragesIndicators(int page);
}
