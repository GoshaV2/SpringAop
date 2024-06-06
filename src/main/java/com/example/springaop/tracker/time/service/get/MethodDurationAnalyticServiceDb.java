package com.example.springaop.tracker.time.service.get;

import com.example.springaop.tracker.time.aspect.TrackAsyncTime;
import com.example.springaop.tracker.time.controller.dto.mapper.MethodDurationMapper;
import com.example.springaop.tracker.time.controller.dto.response.MethodDurationAnalyticListResponse;
import com.example.springaop.tracker.time.model.MethodDurationAnalytic;
import com.example.springaop.tracker.time.repository.MethodDurationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MethodDurationAnalyticServiceDb implements MethodDurationAnalyticService {
    public static final int PAGE_SIZE_LIMIT = 50;
    private final MethodDurationRepository methodDurationRepository;

    @Override
    @TrackAsyncTime
    public MethodDurationAnalyticListResponse getAveragesIndicators(int page) {
        Slice<MethodDurationAnalytic> methodDurationAnalyticSlice =
                methodDurationRepository.getAveragesIndicators(PageRequest.of(page, PAGE_SIZE_LIMIT));
        return MethodDurationMapper.toMethodDurationAnalyticListResponse(methodDurationAnalyticSlice.hasNext(),
                methodDurationAnalyticSlice.getContent());
    }
}
