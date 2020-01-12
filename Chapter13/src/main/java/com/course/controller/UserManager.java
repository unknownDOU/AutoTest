package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2020/01/08
 */

@Log4j
@RestController
@Api(value = "v1" ,description = "用户管理系统")
@RequestMapping("/v1")
public class UserManager {


    @Autowired
    private SqlSessionTemplate template;

    @ApiOperation(value = "登陆接口",httpMethod = "POST")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Boolean login(HttpServletResponse response, @RequestBody User user){

        int i = template.selectOne("login",user);
        Cookie cookie = new Cookie("session","aaaaaa");
        response.addCookie(cookie);
        log.info("查询到的结果"+i);
        if (i ==1){
            log.info("查询到的用户："+user.getUsername());
            return true;
        }
        return false;
    }

    @ApiOperation(value = "添加用户接口",httpMethod = "POST")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Boolean addUser(HttpServletRequest request,@RequestBody User user){
        Boolean x = verifyCookies(request);
        int result = 0;
        if (x == true){
            result = template.insert("addUser",user);
        }
        if (result > 0){
            log.info("添加用户成功，新用户是："+user.getUsername());
            return true;
        }
        return false;
    }

    @ApiOperation(value = "获取用户信息接口",httpMethod = "POST")
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    public List<User> getUserInfo(HttpServletRequest request,@RequestBody User user){
        Boolean x = verifyCookies(request);

        if (x == true){
            List<User> users = template.selectList("getUserInfo",user);
            log.info("查询到的用户数："+users.size());
            return users;
        }
        else {
            return null;
        }

    }

    @ApiOperation(value = "更新/删除用户接口",httpMethod = "POST")
    @RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
    public int updateUser(HttpServletRequest request, @RequestBody User user){
        Boolean x = verifyCookies(request);
        int result = 0;
        if (x == true){
            result = template.update("updateUser",user);
        }

        log.info("更新用户成功，更新的用户是："+user.getUsername());
        return result;


    }


    //判断用户是否登陆成功
    private Boolean verifyCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)){
            log.info("cookies为空");
            return false;

        }
        for (Cookie cookie :cookies){
            if (cookie.getName().equals("session")&&cookie.getValue().equals("aaaaaa")){
                log.info("cookies is true");
                return true;
            }
        }
        return false;

    }

}
