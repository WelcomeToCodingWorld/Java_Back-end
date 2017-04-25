/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jackie.springmvc.service;
//import com.jackie.springmvc.common.DBConnection;
import com.jackie.springmvc.model.User;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import javax.jws.WebService;

/**
 *
 * @author zz
 */

public interface UserService {
    public boolean register(String userName,String password);

    public  List<User> allusers();

    public  User Login(String name,String pwd);

    public  ArrayList<User> selectUserWithWhereClause(String whereClause);
}
