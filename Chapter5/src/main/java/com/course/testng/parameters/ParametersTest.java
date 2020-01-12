package com.course.testng.parameters;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2019/12/18
 */
public class ParametersTest {

    //使用parameters传参数时，运行时只能通过run xml文件，仅运行类或方法会报错
    //函数所需的参数个数必须与@Parameters保持一致
    @Test
    @Parameters({"name","age"})
    public void test1(String one,String two){
        System.out.println("name = "+one+";"+"age ="+two);
    }
}
