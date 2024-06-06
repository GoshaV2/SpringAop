package com.example.springaop.tracker.time.aspect;

import com.example.springaop.tracker.time.model.ExecutionStatus;
import com.example.springaop.tracker.time.service.save.MethodDurationSaving;
import com.example.springaop.tracker.time.service.save.MethodDurationSaveService;
import com.example.springaop.tracker.time.service.save.MethodDurationSaveServiceFactory;
import com.example.springaop.tracker.time.util.MethodDurationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class TrackTimeAspect {
    public static final boolean IS_ASYNC = false;
    public static final boolean IS_NOT_ASYNC = false;
    public static final ExecutionStatus FAILED_METHOD_EXCECUTION = ExecutionStatus.FAILED;
    public static final ExecutionStatus SUCCESS_METHOD_EXCECUTION = ExecutionStatus.SUCCESS;
    private final MethodDurationSaveServiceFactory methodDurationSaveServiceFactory;

    @Around("@annotation(com.example.springaop.tracker.time.aspect.TrackTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        return saveExecutionTime(joinPoint, IS_ASYNC);
    }

    @Around("@annotation(com.example.springaop.tracker.time.aspect.TrackAsyncTime)")
    public Object logExecutionTimeAsync(ProceedingJoinPoint joinPoint) throws Throwable {
        return saveExecutionTime(joinPoint, IS_NOT_ASYNC);
    }

    private Object saveExecutionTime(ProceedingJoinPoint joinPoint, boolean isAsync) throws Throwable {
        final MethodDurationSaveService methodDurationSaveService = methodDurationSaveServiceFactory.getService(isAsync);
        long start = System.currentTimeMillis();
        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            methodDurationSaveService.invoke(MethodDurationUtils.calculateTimeExecution(start),
                    buildRequest(FAILED_METHOD_EXCECUTION, joinPoint));
            throw e;
        }
        methodDurationSaveService.invoke(MethodDurationUtils.calculateTimeExecution(start),
                buildRequest(SUCCESS_METHOD_EXCECUTION, joinPoint));
        return result;
    }

    private MethodDurationSaving buildRequest(ExecutionStatus status, ProceedingJoinPoint joinPoint) {
        return MethodDurationSaving.builder()
                .status(status)
                .methodName(joinPoint.getSignature().getName())
                .targetClass(joinPoint.getSignature().getDeclaringTypeName())
                .signature(joinPoint.getSignature().toLongString())
                .build();
    }
}
