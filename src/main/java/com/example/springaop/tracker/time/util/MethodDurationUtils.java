package com.example.springaop.tracker.time.util;

public class MethodDurationUtils {
    public static long calculateTimeExecution(long startMilliseconds) {
        return System.currentTimeMillis() - startMilliseconds;
    }
}
