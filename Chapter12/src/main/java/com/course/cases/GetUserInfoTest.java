package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.GetUserInfoCase;
import com.course.model.User;
import com.course.utils.DatabaseUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2020/01/09
 */
public class GetUserInfoTest {

    @Test(dependsOnGroups = "loginTrue",description = "查询用户信息")
    public void getUserInfo() throws IOException, InterruptedException {

        SqlSession sqlSession = DatabaseUtils.getSqlSession();
        GetUserInfoCase getUserInfoCase = sqlSession.selectOne("getUserInfoCase",1);
        System.out.println(getUserInfoCase.toString());
        System.out.println(TestConfig.getUserInfoUrl);

        JSONArray jsonArray = getJsonArray(getUserInfoCase);

        Thread.sleep(2000);
        //验证
        User user = sqlSession.selectOne(getUserInfoCase.getExpected(),getUserInfoCase);
        List userList = new ArrayList();
        userList.add(user);
        JSONArray userInfoJson = new JSONArray(userList);

        System.out.println("a:"+userInfoJson);
        System.out.println("b"+jsonArray);

        Assert.assertEquals(jsonArray.get(0).toString(),userInfoJson.get(0).toString());
//        JSONArray jsonArray1 = new JSONArray(jsonArray.getString(0));
//        Assert.assertEquals(jsonArray.getJSONArray(0).toString(),userInfoJson.toString());



    }

    private JSONArray getJsonArray(GetUserInfoCase getUserInfoCase) throws IOException {

        HttpPost post = new HttpPost(TestConfig.getUserInfoUrl);
        JSONObject params = new JSONObject();
        params.put("userId",getUserInfoCase.getUserId());

        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(params.toString(),"utf-8");
        post.setEntity(entity);

        TestConfig.defaultHttpClient.setCookieStore(TestConfig.cookieStore);

        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);

        result = EntityUtils.toString(response.getEntity(),"utf-8");
        JSONArray jsonArray = new JSONArray(result);
        return jsonArray;


    }

}
