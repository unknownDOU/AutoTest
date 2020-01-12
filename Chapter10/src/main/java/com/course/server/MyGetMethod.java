package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2019/12/24
 */
@RestController
@Api(value = "/",description = "这是我全部的get方法")
public class MyGetMethod {

    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取cookies",httpMethod = "GET")
    public String getCookies(HttpServletResponse response){

//        HttpServletRequest  装请求信息的类
//        HttpServletResponse 装响应信息的类
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "获得cookies成功";
    }

    /**
     * 要求客户端携带cookies访问
     * 这是一个需要携带cookies信息才能访问的get请求
     */
    @RequestMapping(value = "/get/with/cookies" ,method = RequestMethod.GET)
    @ApiOperation(value = "要求客户端携带cookies访问",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            return "请求必须携带cookies信息";
        }
        for (Cookie cookie :cookies){
            if (cookie.getName().equals("login")&&cookie.getValue().equals("true")){
                return "这是一个需要携带cookies信息才能访问的get请求";
            }
        }
        return "请求出错了";

    }

    /**
     *开发一个需要携带参数才能访问的get请求
     * url格式：？key=value&key=value
     * 我们来模拟获取商品列表
     */
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value ="一个需要携带参数才能访问的get请求",httpMethod = "GET")
    public Map getList(@RequestParam int start,@RequestParam int end){
        Map<String,Integer> map = new HashMap<>();
        map.put("辣条",2);
        map.put("蛋糕",10);
        map.put("饼干",12);

        return map;
    }

    /**
     *开发一个需要携带参数才能访问的get请求
     * url格式：ip:port/gei/{20}
     * 我们来模拟获取商品列表
     */
    @RequestMapping(value = "/get/pathVariable/{start}",method = RequestMethod.GET)
    @ApiOperation(value = "一个需要携带参数和cookies才能访问的get请求" ,httpMethod = "GET")
    public Map getWithPathParam(@PathVariable Integer start,HttpServletRequest request){

        Map<String,Integer> map = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            Map<String,String> map1 = new HashMap<>();
            map1.put("message","请携带cookies信息");
            return map1 ;
        }
        for (Cookie cookie :cookies){
            if (cookie.getName().equals("login")&&cookie.getValue().equals("true")){
                map.put("辣条",2);
                map.put("蛋糕",10);
                map.put("饼干",12);

                return map;
            }
        }
        return map;

    }



}
