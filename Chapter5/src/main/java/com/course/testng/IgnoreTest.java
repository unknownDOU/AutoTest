package com.course.testng;

import org.testng.annotations.Test;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2019/12/18
 */
public class IgnoreTest {

    @Test
    public void ignore1(){
        System.out.println("ignore1 run");
    }

    //属性enabled 值为false时，测试方法不执行；无属性enabled或enabled值为true时，测试方法执行
    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore2 run");
    }

    @Test(enabled = true)
    public void ignore3(){
        System.out.println("ignore3 rum");
    }
}
