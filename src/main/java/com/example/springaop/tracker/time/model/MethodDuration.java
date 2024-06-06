package com.example.springaop.tracker.time.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "method_duration")
public class MethodDuration {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ExecutionStatus status;

    @Column(name = "method_name", nullable = false)
    private String methodName;

    @Column(name = "method_target_class", nullable = false)
    private String methodTargetClass;

    @Column(name = "signature", nullable = false)
    private String signature;
    /**
     * Using milliseconds
     */
    @Column(name = "duration", nullable = false)
    private long duration;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
