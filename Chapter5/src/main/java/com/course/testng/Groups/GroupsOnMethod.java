package com.course.testng.Groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2019/12/18
 */
public class GroupsOnMethod {

    @Test(groups = "server" )
    public void test1(){
        System.out.println("这是服务端test1");
    }

    @Test(groups = "server" )
    public void test2(){
        System.out.println("这是服务端test2");
    }

    @Test(groups = "client" )
    public void test3(){
        System.out.println("这是客户端test1");
    }
    @Test(groups = "client" )
    public void test4(){
        System.out.println("这是客户端test1");
    }

    //BeforeGroups、AfterGroups的使用，后面必须带有组名，否则运行无结果
    @BeforeGroups("client")
    public void beforeGroupsOnMethod(){
        System.out.println("在服务端测试前运行");
    }

    @AfterGroups("client")
    public void afterGroupsOnMethod(){
        System.out.println("在服务端测试后运行");
    }


}
