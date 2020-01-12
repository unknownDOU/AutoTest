package com.course.config;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2020/01/03
 */
public class TestConfig {
    public static  String loginUrl;
    public static  String updateUserInfoUrl;
    public static String getUserInfoUrl;
    public static  String getUserListUrl;
    public static String addUserUrl;

    public static DefaultHttpClient defaultHttpClient;
    public static CookieStore cookieStore;

}
