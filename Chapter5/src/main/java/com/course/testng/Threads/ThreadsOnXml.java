package com.course.testng.Threads;

import org.testng.annotations.Test;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2019/12/18
 */
public class ThreadsOnXml {

    @Test
    public void test(){
        System.out.printf("thread id : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test1(){
        System.out.printf("thread id : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test2(){
        System.out.printf("thread id : %s%n",Thread.currentThread().getId());
    }
}
