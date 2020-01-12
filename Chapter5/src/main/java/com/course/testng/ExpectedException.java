package com.course.testng;

import org.testng.annotations.Test;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2019/12/18
 */
public class ExpectedException {

    //测试结果会失败的异常测试
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed() {
        System.out.println("this is a failed test");
    }


    //测试结果成功的异常测试
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess() {
        System.out.println("this is a successful test");
        throw new RuntimeException();

    }
}

