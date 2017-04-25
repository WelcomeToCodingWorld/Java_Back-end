/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jackie.springmvc.controller;
import com.jackie.springmvc.common.JsonUtil;
import com.jackie.springmvc.model.User;
import com.jackie.springmvc.service.UserServiceImpl;
import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author zz
 */
@Controller
public class UserController {
    //指定该方法为一个action
    private final UserServiceImpl userService = new UserServiceImpl();
     
 
    @RequestMapping(value="/privateapi/allusers",method={RequestMethod.POST, RequestMethod.GET},produces=MediaType.APPLICATION_JSON_VALUE,headers = "Accept=application/json")
    @ResponseBody
    private String allUsers() throws JSONException, IOException{
        JsonUtil jsonUtil = new JsonUtil();
        JSONObject jsonObj = new JSONObject();
        String msg = "sdsgwe";
        String code = "102";
        List<User> userList;
        userList = userService.allusers();
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
        return jsonObj.toString();
    }
}
