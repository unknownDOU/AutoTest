package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.GetUserListCase;
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
import java.util.List;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2020/01/09
 */
public class GetUserInfoListTest {


    @Test(dependsOnGroups = "loginTrue",description = "获取性别为男的信息")
    public void getUserInfoList() throws IOException, InterruptedException {

        SqlSession sqlSession = DatabaseUtils.getSqlSession();
        GetUserListCase getUserListCase = sqlSession.selectOne("getUserInfoListCase",1);
        System.out.println(getUserListCase.toString());
        System.out.println(TestConfig.getUserListUrl);

        //发送请求获取结果
        JSONArray jsonArray = getJsonArray(getUserListCase);

        //验证
//        Thread.sleep(3000);
        List<User> userList = sqlSession.selectList(getUserListCase.getExpected(),getUserListCase);
        for (User u :userList){
            System.out.println("获取的："+u.toString());
        }

        JSONArray userListJson = new JSONArray(userList);
//        Assert.assertEquals(userListJson.length(),jsonArray.length());

        for (int i=0;i < userListJson.length();i++){
            JSONObject expect =(JSONObject) jsonArray.get(i);
            JSONObject actual =(JSONObject) userListJson.get(i);

            System.out.println("a:"+expect);
            System.out.println("b:"+actual);

            String expectOne = expect.getString("username");
            String actualOne = actual.getString("username");
            Assert.assertEquals(expectOne,actualOne);
//            Assert.assertEquals(expect.toString(),actual.toString());


        }


    }

    private JSONArray getJsonArray(GetUserListCase getUserListCase) throws IOException {

        HttpPost post = new HttpPost(TestConfig.getUserListUrl);
        JSONObject params = new JSONObject();
        params.put("userName",getUserListCase.getUserName());
        params.put("sex",getUserListCase.getSex());
        params.put("age",getUserListCase.getAge());

        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(params.toString(),"utf-8");

        post.setEntity(entity);

        TestConfig.defaultHttpClient.setCookieStore(TestConfig.cookieStore);
        String result;

        HttpResponse response = TestConfig.defaultHttpClient.execute(post);

        result = EntityUtils.toString(response.getEntity(),"utf-8");

        JSONArray jsonObject = new JSONArray(result);

        return jsonObject;


    }
}
