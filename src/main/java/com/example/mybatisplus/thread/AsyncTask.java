package com.example.mybatisplus.thread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author xufeng
 * @version 1.0
 * @date 2020/6/23 上午 11:07
 **/
@Component
public class AsyncTask {

    @Async("taskExecutor")
    public void tesTask(){
        System.out.println(Thread.currentThread().getName());
    }
}
