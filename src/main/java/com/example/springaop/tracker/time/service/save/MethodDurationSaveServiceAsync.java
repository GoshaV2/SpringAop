package com.example.springaop.tracker.time.service.save;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Qualifier("async")
@Service
public class MethodDurationSaveServiceAsync implements MethodDurationSaveService {
    private final MethodDurationSaveService methodDurationSaveService;

    public MethodDurationSaveServiceAsync(@Qualifier("sync") MethodDurationSaveService methodDurationSaveService) {
        this.methodDurationSaveService = methodDurationSaveService;
    }

    @Override
    @Async
    public void invoke(long executionMilliseconds, MethodDurationSaving request) {
        methodDurationSaveService.invoke(executionMilliseconds, request);
    }
}
