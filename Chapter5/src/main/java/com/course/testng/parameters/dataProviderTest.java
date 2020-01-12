package com.course.testng.parameters;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2019/12/18
 */
public class dataProviderTest {
    
    
    @Test(dataProvider = "dataTest")
    public void testDataProvider(String name ,int age){
        System.out.println("name = "+name+";"+"age ="+age);
    }

    @DataProvider(name = "dataTest")
    public Object[][] data(){
        Object[][] result = new Object[][]{
                {"zhangsan",10},
                {"lisi",20}
        };
        return result;
    }
    
    @Test(dataProvider = "test")
    public void  test1(String name,int age){
        System.out.println("name ="+name+";"+"agea= "+age);
    }

    @Test(dataProvider = "test")
    public void  test2(String name,int age){
        System.out.println("name ="+name+";"+"agea= "+age);
    }
    
    @DataProvider(name = "test")
    public Object[][] dataProvider(Method method){
        
        Object[][] result = null;
        if (method.getName().equals("test1")){
            result = new Object[][]{
                    {"one",1},
                    {"two",2}
            };
        }
        else if (method.getName().equals("test2")){
            result = new  Object[][]{
                    {"zhangsan",30},
                    {"lisi",40}
            };
        }
        
        return result;
    }
}
