package com.course.testng;

import org.testng.annotations.Test;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2019/12/18
 */
public class DependTest {

    @Test
    public void test1(){
        System.out.println("this is a testOne");
//        throw new RuntimeException();
    }

    //test2依赖于test1和test3,如果test1或test3异常了，那么test2将不会被执行
    @Test(dependsOnMethods = {"test1","test3"})
    public void test2(){
        System.out.println("this is a testTwo");
    }

    @Test
    public void test3(){
        System.out.println("this is a testThree");
        throw new RuntimeException();
    }


}
