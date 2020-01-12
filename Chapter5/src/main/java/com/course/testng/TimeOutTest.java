package com.course.testng;

import org.testng.annotations.Test;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2019/12/19
 */
public class TimeOutTest {

    @Test(timeOut = 3000 )//单位为毫秒
    public void testSuccess() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(timeOut = 2000)
    public void testfail() throws InterruptedException {
        Thread.sleep(3000);
    }
}
