package com.course.httpClient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2019/12/20
 */
public class MyCookiesForGet {

    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public void getUrl(){
        bundle = ResourceBundle.getBundle("application", Locale.CANADA);
        url = bundle.getString("test.uri");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        //从配置文件中获取信息
        HttpGet get = new HttpGet(url+bundle.getString("test.getCookies.uri"));
        //测试逻辑代码书写
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);

        result = EntityUtils.toString(response.getEntity(),"utf-8");

        System.out.println(result);


        //获取cookies
        this.store = client.getCookieStore();
        List<Cookie> cookies= store.getCookies();

        for (Cookie cookie : cookies){
            String name = cookie.getName();
            String value = cookie.getValue();

            System.out.println("cookie name:"+name+";"+"cookie value:"+value);
        }


    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException {
        HttpGet get = new HttpGet(url+bundle.getString("test.get.demo.cookies"));
        DefaultHttpClient client = new DefaultHttpClient();

        //发送cookies
        client.setCookieStore(store);
        HttpResponse response = client.execute(get);

        //获取状态码
        int responseCode = response.getStatusLine().getStatusCode();

        if (responseCode == 200){
            String result;
            result = EntityUtils.toString(response.getEntity(),"utf-8");

            System.out.println(result);

        }





    }





}
