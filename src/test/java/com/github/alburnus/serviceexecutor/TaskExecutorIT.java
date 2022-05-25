package com.github.alburnus.serviceexecutor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaskExecutorIT {

    @Autowired
    private TaskExecutor taskExecutor;

    @Test
    void test() {
        taskExecutor.runTasks();
    }
}