package com.example.springaop.tracker.time.model;

public interface MethodDurationAnalytic {
    String getMethodName();

    String getMethodTargetClass();

    String getSignature();

    double getAverageDuration();

    long getMaxDuration();

    long getMinDuration();
}
