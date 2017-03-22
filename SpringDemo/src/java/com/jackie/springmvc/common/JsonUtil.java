/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jackie.springmvc.common;

import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.ObjectCodec;
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
            StackTraceElement stackTraceElement= e.getStackTrace()[0];// 得到异常棧的首个元素
            System.out.println("File="+stackTraceElement.getFileName());// 打印文件名
            System.out.println("Line="+stackTraceElement.getLineNumber());// 打印出错行号
            System.out.println("Method="+stackTraceElement.getMethodName());// 打印出错方法 
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
