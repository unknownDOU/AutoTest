package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.UpdateUserInfoCase;
import com.course.model.User;
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
import java.io.UnsupportedEncodingException;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2020/01/09
 */
public class UpdateUserInfoTest {


    @Test(dependsOnGroups = "loginTrue",description = "更新用户信息")
    public void updateUserInfo() throws IOException, InterruptedException {

        SqlSession sqlSession = DatabaseUtils.getSqlSession();
        UpdateUserInfoCase updateUserInfoCase = sqlSession.selectOne("updateUserInfoCase",1);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestConfig.updateUserInfoUrl);

        //请求接口获取返回值
        int result = getResult(updateUserInfoCase);


        Thread.sleep(15000);

        //验证
        User user = sqlSession.selectOne(updateUserInfoCase.getExpected(),updateUserInfoCase);

        Assert.assertNotNull(result);
        Assert.assertNotNull(user);
        
    }



    @Test(dependsOnGroups = "loginTrue",description = "删除用户信息")
    public void deleteUserInfo() throws IOException, InterruptedException {
        SqlSession sqlSession = DatabaseUtils.getSqlSession();
        UpdateUserInfoCase updateUserInfoCase = sqlSession.selectOne("updateUserInfoCase",2);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestConfig.updateUserInfoUrl);

        //请求接口获取返回值
        int result = getResult(updateUserInfoCase);

        Thread.sleep(10000);

        //验证
        User user = sqlSession.selectOne(updateUserInfoCase.getExpected(),updateUserInfoCase);

        Assert.assertNotNull(result);
        Assert.assertNotNull(user);
    }



    private int getResult(UpdateUserInfoCase updateUserInfoCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.updateUserInfoUrl);
        JSONObject params = new JSONObject();
        params.put("id",updateUserInfoCase.getUserId());
        params.put("username",updateUserInfoCase.getUserName());
        params.put("password",updateUserInfoCase.getPassword());
        params.put("age",updateUserInfoCase.getAge());
        params.put("sex",updateUserInfoCase.getSex());
        params.put("permission",updateUserInfoCase.getPermission());
        params.put("isDelete",updateUserInfoCase.getIsDelete());

        post.setHeader("content-type","application/json");

        StringEntity entity = new StringEntity(params.toString(),"utf-8");

        post.setEntity(entity);

        TestConfig.defaultHttpClient.setCookieStore(TestConfig.cookieStore);

        HttpResponse response = TestConfig.defaultHttpClient.execute(post);

        String result;
        result = EntityUtils.toString(response.getEntity(),"utf-8");


        return  Integer.parseInt(result);

    }
}
