package com.course.testng;

import org.testng.annotations.*;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2019/12/17
 */
public class BasicAnnotation {

    //最基本的注解，用来把方法标记为测试的一部分
    @Test
    public void testCase1(){
        System.out.println("这是测试用例1");
    }

    @Test
    public void testCase2(){
        System.out.println("这是测试用例2");
    }
    
    //beforeMethod 和 AfterMethod 注解在每一个测试方法上都会运行一次
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod这是在测试方法前运行的");

    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod这是在测试方法后运行的");
    }


    //beforeClass 和 afterClass 在类之前或之后运行，与方法无关
    @BeforeClass
    public void  beforeClass(){
        System.out.println("beforeClass这是在类运行之前的方法");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass这是在类运行之后的方法");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuit测试套件");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite测试套件");
    }

    @BeforeGroups
    public void beforeGroups(){
        System.out.println("beforeGroups测试套件");
    }
    @AfterGroups
    public void afterCroups(){
        System.out.println("afterGroups");
    }

   @BeforeTest
   public void beforeTest(){
       System.out.println("beforeTest");
   }


   @AfterTest
   public void afterTest(){
       System.out.println("afterTest");
   }



}
