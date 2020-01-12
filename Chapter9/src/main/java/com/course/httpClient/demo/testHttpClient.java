package com.course.httpClient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.DefaultHttpClient;

import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2019/12/20
 */
public class testHttpClient {

    @Test
    public void test1() throws IOException {
        //用来存放结果
        String result;

        HttpGet get = new HttpGet("https://www.baidu.com");
        HttpClient client = new DefaultHttpClient();
        //获得返回值
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");

        System.out.println(result);

    }
}
