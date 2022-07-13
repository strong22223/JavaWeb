package com.Strong.json;

import com.Strong.pojo.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class FastJsonDemo {
    public static void main(String[] args) {

        User user = new User(1, "zhansan", "lll");
        //1.将java对象转为  JSON
        String s = JSON.toJSONString(user);//{"id":1,"password":"lll","username":"zhansan"}
        System.out.println(s);
        //2.将JSON字符串转为Java对象

        JSONObject jsonObject = JSON.parseObject("{\"id\":1,\"password\":\"lll\",\"username\":\"zhansan\"}");

        System.out.println(jsonObject);


    }
}
