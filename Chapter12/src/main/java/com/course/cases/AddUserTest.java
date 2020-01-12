package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.User;
import com.course.model.addUserCase;
import com.course.utils.DatabaseUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2020/01/09
 */
public class AddUserTest {

    @Test(dependsOnGroups = "loginTrue",description = "添加用户接口")
    public void addUser() throws IOException, InterruptedException {
        SqlSession session = DatabaseUtils.getSqlSession();
        addUserCase addUserCase = session.selectOne("addUserCase",1);
        System.out.println(addUserCase.toString());
        System.out.println(TestConfig.addUserUrl);


        //发送请求，获取结果
        String result = getResult(addUserCase);

        Thread.sleep(3000);
        //验证返回结果
//        User user = session.selectOne("addUser",addUserCase);

        String u = addUserCase.getExpected();

        Assert.assertEquals(addUserCase.getExpected(),result);



    }

    private String getResult(addUserCase addUserCase) throws IOException {

        HttpPost post = new HttpPost(TestConfig.addUserUrl);
        JSONObject params = new JSONObject();
        params.put("username",addUserCase.getUserName());
        params.put("password",addUserCase.getPassword());
        params.put("age",addUserCase.getAge());
        params.put("sex",addUserCase.getSex());
        params.put("permission",addUserCase.getPermission());
        params.put("isDelete",addUserCase.getIsDelete());

        //设置头信息
        post.setHeader("content-type","application/json");

        StringEntity entity = new StringEntity(params.toString(),"utf-8");
        post.setEntity(entity);

        //设置cookies
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.cookieStore);

        //存放放回结果
        String result;

        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");


        System.out.println(result);

        return result;
    }

}
