package com.course.testng.Threads;

import org.testng.annotations.Test;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2019/12/18
 */
public class ThreadsOnAnnotion {

    @Test(invocationCount = 2,threadPoolSize = 4)
    public void test(){
        System.out.println("1");
        System.out.printf("Thread Id: %s%n",Thread.currentThread().getId());
    }
}
