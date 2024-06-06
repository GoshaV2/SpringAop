package com.example.springaop.tracker.time.controller.dto.mapper;

import com.example.springaop.tracker.time.controller.dto.response.MethodDurationAnalyticListResponse;
import com.example.springaop.tracker.time.controller.dto.response.MethodDurationAnalyticResponse;
import com.example.springaop.tracker.time.model.MethodDurationAnalytic;

import java.util.Collection;

public class MethodDurationMapper {
    public static MethodDurationAnalyticResponse toMethodDurationAnalyticResponse(MethodDurationAnalytic methodDurationAnalytic) {
        return MethodDurationAnalyticResponse.builder()
                .methodName(methodDurationAnalytic.getMethodName())
                .methodTargetClass(methodDurationAnalytic.getMethodTargetClass())
                .signature(methodDurationAnalytic.getSignature())
                .averageDuration(methodDurationAnalytic.getAverageDuration())
                .maxDuration(methodDurationAnalytic.getMaxDuration())
                .minDuration(methodDurationAnalytic.getMinDuration())
                .build();
    }

    public static MethodDurationAnalyticListResponse toMethodDurationAnalyticListResponse(
            boolean hasNext, Collection<MethodDurationAnalytic> methodDurationAnalytics) {
        return new MethodDurationAnalyticListResponse(methodDurationAnalytics.stream()
                .map(MethodDurationMapper::toMethodDurationAnalyticResponse)
                .toList(),
                hasNext,
                methodDurationAnalytics.size()
        );
    }
}
