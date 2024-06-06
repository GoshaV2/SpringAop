package com.example.springaop.tracker.time.service.save;

import com.example.springaop.tracker.time.model.ExecutionStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MethodDurationSaving {
    private ExecutionStatus status;
    private String methodName;
    private String targetClass;
    private String signature;
}
