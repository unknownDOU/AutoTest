package com.course.testng.Groups;

import org.testng.annotations.Test;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2019/12/18
 */

@Test(groups = "stu")
public class GroupsOnClass2 {

    public void test1(){
        System.out.println("GroupsOnClass2 中运行的方法");
    }
}
