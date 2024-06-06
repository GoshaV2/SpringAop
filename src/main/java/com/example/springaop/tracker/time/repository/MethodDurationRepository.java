package com.example.springaop.tracker.time.repository;

import com.example.springaop.tracker.time.model.MethodDuration;
import com.example.springaop.tracker.time.model.MethodDurationAnalytic;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MethodDurationRepository extends JpaRepository<MethodDuration, UUID> {
    @Query("""
            select m.methodTargetClass as methodTargetClass,m.signature as signature,
            m.methodName as methodName,max(m.duration) as maxDuration ,
            min(m.duration) as minDuration,avg(m.duration) as averageDuration
            from MethodDuration m group by m.methodName,m.methodTargetClass,m.signature
            """)
    Slice<MethodDurationAnalytic> getAveragesIndicators(Pageable pageable);
}



