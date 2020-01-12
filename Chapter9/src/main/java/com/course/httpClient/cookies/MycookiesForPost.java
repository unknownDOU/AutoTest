package com.course.httpClient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2019/12/21
 */
public class MycookiesForPost {

    /**
     *     获取host地址
     */
    private ResourceBundle bundle = ResourceBundle.getBundle("application");
    private String host = bundle.getString("test.uri");

    private CookieStore store;


    //获取cookies
    @Test
    public void testGetCookies() throws IOException {

        //获取测试地址
        String testUrl = host + bundle.getString("test.getCookies.uri");

        //请求获取cookies的接口
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(testUrl);
        HttpResponse response = client.execute(get);

        //获取cookies
        this.store = client.getCookieStore();

    }


    //请求post接口
    @Test(dependsOnMethods = {"testGetCookies"})
    public void  testPostWithCookies() throws IOException {

        //获取测试地址
        String testUrl = host + bundle.getString("test.post.demo.cookies");

        //设置post请求
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(testUrl);


        //设置参数
        JSONObject param = new JSONObject();
        param.put("name", "zhangsan");
        param.put("age", "18");

        //将参数添加在请求方法里
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        //请求添加cookies
        client.setCookieStore(store);

        //执行post请求
        HttpResponse response = client.execute(post);

        //获取返回值
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        JSONObject resultJson = new JSONObject(result);

        //判断结果值是否正常
        String message = resultJson.getString("message");
        Assert.assertEquals("success",message);

        String status = resultJson.getString("status");
        Assert.assertEquals("1",status);





    }




}
