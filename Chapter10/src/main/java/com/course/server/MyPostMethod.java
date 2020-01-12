package com.course.server;

import com.course.beam.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2019/12/27
 */
@RestController
@Api(value = "/",description = "这是post下全部的接口")
public class MyPostMethod {

    //获取登陆后的cookis值
    private static Cookie cookie;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登陆接口",httpMethod = "POST")
    public String login(HttpServletResponse response, @RequestParam String userName,
                        @RequestParam String passWord ){

        if (userName.equals("zhangsan")&&passWord.equals("true")){

            cookie = new Cookie("login","true");
//            cookie = new Cookie("name","true");
            response.addCookie(cookie);

            return "登陆成功";
        }
        return "用户名或密码错误！";

    }

    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户接口", httpMethod = "POST")
    public  String getUserList(HttpServletRequest request, @RequestBody User user){

        //获取cookies
        Cookie[] cookies = request.getCookies();
        //验证cookies
        for (Cookie c : cookies){
            if (c.getName().equals("login")&&c.getValue().equals("123456")
            &&user.getUserName().equals("zhangsan")
            &&user.getPassWord().equals("123456")){
                User user1 = new User();
                user1.setName("lisi");
                user1.setAge("18");
                user1.setSex("man");

                return user1.toString();

            }
        }
        return "参数不合法";



    }
}
