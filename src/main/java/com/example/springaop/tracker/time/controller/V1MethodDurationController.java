package com.example.springaop.tracker.time.controller;

import com.example.springaop.tracker.time.controller.dto.response.MethodDurationAnalyticListResponse;
import com.example.springaop.tracker.time.service.get.MethodDurationAnalyticService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/methodDuration")
@RequiredArgsConstructor
public class V1MethodDurationController {
    private final MethodDurationAnalyticService methodDurationAnalyticService;

    @GetMapping("/analytics")
    public MethodDurationAnalyticListResponse analyze(@RequestParam("page") int page) {
        return methodDurationAnalyticService.getAveragesIndicators(page);
    }
}
