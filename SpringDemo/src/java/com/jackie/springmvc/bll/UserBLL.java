/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jackie.springmvc.bll;

import com.jackie.springmvc.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.jackie.springmvc.common.DBConnection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zz
 */
public class UserBLL {
    public boolean register(String userName,String password){
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flag = false;
        
        try {
            conn = db.getConnection();
            String sql = "Insert Into User values(?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            ps.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        db.close(ps);
        db.close(conn);
        return flag;
    }
    
    public static List<User> allusers(){
        return UserBLL.selectUserWithWhereClause("");
    }
    
    public static User Login(String name,String pwd){
        User user = null;
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps  = null;
        ResultSet rs = null;
        
        try {
            //创建与数据库引擎的连接
            conn = db.getConnection();
            String sql = "Select * from User Where name =? and pwd = ?";
            ps = conn.prepareStatement(sql);
            ps.setNString(1, name);
            ps.setNString(2, pwd);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                user = new User();
                user.setName(rs.getNString("name"));
                user.setAge(rs.getInt("age"));
                user.setAddress(rs.getNString("address"));
                user.setPhone(rs.getNString("phone"));
                user.setSex(rs.getBoolean("gender"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        
        db.close(rs);
        db.close(ps);
        db.close(conn);
        return user;
    }
    
    public static ArrayList<User> selectUserWithWhereClause(String whereClause){
        ArrayList<User> userList = new ArrayList<>();
        User user = null;
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps  = null;
        ResultSet rs = null;
        
        try {
            //创建与数据库引擎的连接
            conn = db.getConnection();
            String sql = "Select * from User";
            if (!whereClause.isEmpty()&&whereClause != null) {
                System.out.println("呵呵");
                sql += " where" + whereClause;
            }
            
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println(sql);
            while (rs.next()) {
                
                user = new User();
                user.setName(rs.getNString("name"));
                user.setAge(rs.getInt("age"));
                user.setAddress(rs.getNString("address"));
                user.setPhone(rs.getNString("phone"));
                user.setSex(rs.getBoolean("gender"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        
        db.close(rs);
        db.close(ps);
        db.close(conn);
        return userList;
    }
}
