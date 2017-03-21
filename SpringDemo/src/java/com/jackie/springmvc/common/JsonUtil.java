/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jackie.springmvc.common;

import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author zz
 */
public class JsonUtil {
    public static<T>  Object jsonToObj(String jsonStr,Class<T> obj){
        T t = null;
        try {
            ObjectMapper objectmapper = new ObjectMapper();
            t = objectmapper.readValue(jsonStr, obj);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }
    
    public static<T> JSONObject objectToJSON(T obj) throws JSONException, IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = "";
        try {
            jsonStr = objectMapper.writeValueAsString(obj);
        } catch (IOException e) {
            throw e;
        }
        return new JSONObject(jsonStr);
    }
}
