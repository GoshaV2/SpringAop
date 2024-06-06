package com.example.springaop.tracker.time.service.save;

import com.example.springaop.tracker.time.model.MethodDuration;
import com.example.springaop.tracker.time.repository.MethodDurationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Qualifier("sync")
@Service
@Slf4j
@RequiredArgsConstructor
public class MethodDurationSaveServiceSync implements MethodDurationSaveService {
    private final MethodDurationRepository methodDurationRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void invoke(long executionMilliseconds, MethodDurationSaving request) {
        MethodDuration methodDuration = MethodDuration.builder()
                .status(request.getStatus())
                .methodName(request.getMethodName())
                .methodTargetClass(request.getSignature())
                .signature(request.getSignature())
                .duration(executionMilliseconds)
                .build();
        methodDurationRepository.save(methodDuration);
    }
}
