package com.example.springaop.tracker.time.service.save;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MethodDurationSaveServiceFactory {
    private final MethodDurationSaveService methodDurationSaveServiceSync;
    private final MethodDurationSaveService methodDurationSaveServiceAsync;

    public MethodDurationSaveServiceFactory(@Qualifier("sync") MethodDurationSaveService methodDurationSaveServiceSync,
                                            @Qualifier("async") MethodDurationSaveService methodDurationSaveServiceAsync) {
        this.methodDurationSaveServiceSync = methodDurationSaveServiceSync;
        this.methodDurationSaveServiceAsync = methodDurationSaveServiceAsync;
    }

    public MethodDurationSaveService getService(boolean async) {
        if (async) {
            return methodDurationSaveServiceAsync;
        }
        return methodDurationSaveServiceSync;
    }
}
