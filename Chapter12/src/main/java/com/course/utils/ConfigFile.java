package com.course.utils;

import com.course.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2020/01/03
 */
public class ConfigFile {
    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CANADA);
    public static String getUrl(InterfaceName name){

        String host = bundle.getString("test.url");
        String uri = "";

        //最终地址
        String testUrl ;
        if (name == InterfaceName.LOGIN){
            uri = bundle.getString("login.uri");
        }
        else if (name == InterfaceName.ADDUSERINFO)
        {
            uri = bundle.getString("addUser.uri");
        }
        else if (name == InterfaceName.GETUSERINFO){
            uri = bundle.getString("getUserInfo.uri");
        }
        else if (name == InterfaceName.GETUSERLIST){
            uri = bundle.getString("getUserList.uri");
        }
        else if (name == InterfaceName.UPDATEUSERINFO){
            uri = bundle.getString("updateUserInfo.uri");
        }


        testUrl = host + uri;


        return testUrl;
    }

}
