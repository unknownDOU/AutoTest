package com.course.testng.Groups;

import org.testng.annotations.Test;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2019/12/18
 */
@Test(groups = "teacher")
public class GroupsOnClass3 {

    public void test1(){
        System.out.println("GroupsOnClass3 中运行的方法");
    }
}
