package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2019/12/30
 */
@Log4j
@RestController
public class demo {

    //获取执行sql的对象  Autowired预加载

    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    public int getUserCount(){
        return template.selectOne("one");
    }


    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public int addUser(@RequestBody User user){
        int result = template.insert("addUser",user);
        return result ;
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public int updateUser(@RequestBody User user){
        return  template.update("updateUser",user) ;
    }

    @RequestMapping(value = "/delUser",method = RequestMethod.GET)
    public int delUser(@RequestParam int id){

        return template.delete("delUser",id);
    }

}
