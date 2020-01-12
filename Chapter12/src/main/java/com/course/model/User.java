package com.course.model;

import lombok.Data;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2020/01/03
 */

@Data
public class User {

    private int id;
    private String username;
    private String password;
    private String age;
    private String sex;
    private String permission;
    private String isDelete;

    @Override
    public String toString(){

        return (
                "{id :"+id +","+
                "username :"+username+","+
                "password :"+password +","+
                "age :"+age +","+
                "sex :"+sex +","+
                "permission :"+permission +","+
                "isDelete :"+isDelete +"}"

        );
    }

}
