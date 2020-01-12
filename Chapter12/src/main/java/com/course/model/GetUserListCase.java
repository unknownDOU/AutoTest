package com.course.model;

import lombok.Data;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2020/01/03
 */

@Data
public class GetUserListCase {
    private String userName;
    private String age;
    private String sex;
    private String expected;

}
