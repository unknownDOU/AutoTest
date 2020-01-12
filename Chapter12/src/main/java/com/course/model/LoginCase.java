package com.course.model;

import lombok.Data;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2020/01/03
 */
@Data
public class LoginCase {

    private int id;
    private String username;
    private String password;
    private String expected;
}
