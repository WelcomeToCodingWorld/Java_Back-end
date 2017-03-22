/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jackie.springmvc.controller;
import com.jackie.springmvc.bll.UserBLL;
import com.jackie.springmvc.common.JsonUtil;
import com.jackie.springmvc.model.User;
import java.io.IOException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author zz
 */
@Controller
public class UserController {
    //指定该方法为一个action
     
    @RequestMapping("/privateapi/allusers")
    @ResponseBody
    private JSONObject allUsers() throws JSONException, IOException{
        JsonUtil jsonUtil = new JsonUtil();
        JSONObject jsonObj = new JSONObject();
        String msg = "sdsgwe";
        String code = "102";
        List<User> userList = UserBLL.allusers();
        JSONArray userArr = new JSONArray();
        
        jsonObj.put("msg", msg);
        jsonObj.put("code", code);
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            JSONObject userStr = JsonUtil.objectToJSON(user);
            userArr.put(userStr);
        }
        jsonObj.put("users", userArr);
        System.out.println(jsonObj);
        return jsonObj;
    }
}
