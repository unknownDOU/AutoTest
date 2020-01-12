package com.course.extentreports;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2019/12/19
 */
public class TestMethodDemo {


    @Test
    public void test1(){
        Assert.assertEquals(1,2);

    }
    @Test
    public void test2(){
        Assert.assertEquals(1,1);
    }

    @Test
    public void test3(){
        Assert.assertEquals("aaa","aaa");
    }

    @Test
    public void logDemo(){
        Reporter.log("这是日记");
        throw new RuntimeException("这是异常");
    }

}
