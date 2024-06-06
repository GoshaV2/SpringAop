package com.example.springaop.tracker.time.service.save;

public interface MethodDurationSaveService {
    void invoke(long executionMilliseconds, MethodDurationSaving request);
}
