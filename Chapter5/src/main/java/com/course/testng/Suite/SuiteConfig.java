package com.course.testng.Suite;

import org.testng.annotations.*;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2019/12/18
 */
public class SuiteConfig {

    //beforeSuite 和 afterSuite 在xml文件中所有测试方法运行前或后运行，只运行一次
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuit 运行了");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite 运行了");
    }

    @BeforeSuite
    public void beforeSuite1(){
        System.out.println("beforeSuit1 运行了");
    }

    @AfterSuite
    public void afterSuite1(){
        System.out.println("afterSuite1 运行了");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest 运行了");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("afterTest 运行了");
    }


}
