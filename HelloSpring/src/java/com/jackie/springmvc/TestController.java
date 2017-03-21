/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jackie.springmvc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author zz
 */
@Controller
public class TestController {
    
    @RequestMapping("/greeting")
    public String sayHello(){
        System.out.println("greetingService!");
        return "Success";
    }
}
