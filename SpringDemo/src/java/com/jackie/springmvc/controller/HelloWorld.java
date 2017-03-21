/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jackie.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author zz
 */
//spring的控制器
@Controller
public class HelloWorld {
    //请求映射
    @RequestMapping("/helloworld")
    public String hello(){
        return "Success";
    }
    
}
