package com.github.alburnus.serviceexecutor;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

/**
 * Default Executor Task implementation for interface {@link ExecutorTask}
 */
@Slf4j
public class ExecutorTaskImpl implements ExecutorTask {
    @Override
    public String call() throws Exception {
        String uuid = UUID.randomUUID().toString();
        log.info("Sleep for task with uuid={}", uuid);
        Thread.sleep(5000);
        return uuid;
    }
}
