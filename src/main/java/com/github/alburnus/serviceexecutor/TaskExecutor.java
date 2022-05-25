package com.github.alburnus.serviceexecutor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
@Service("MyTaskExecutor")
public class TaskExecutor {

    public void runTasks() {
        List<Future<String>> futureResults = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            futureResults.add(executorService.submit(new ExecutorTaskImpl()));
        }
        futureResults.forEach(stringFuture -> {
            try {
                String s = stringFuture.get();
                log.info("Result={}", s);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
