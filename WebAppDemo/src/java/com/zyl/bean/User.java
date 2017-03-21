/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zyl.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author zz
 */
public class User {
    private int id;
    private String name;
    private String password;
    private int age;
    private String email;
    private String birthday;
    private float money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }
    
    public static User login(String name,String pwd){
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
                user.name = rs.getNString("name");
                user.email = rs.getNString("email");
                user.id = rs.getInt("userId");
                user.birthday = rs.getNString("birthday");
                user.money = rs.getFloat("money");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        db.close(rs);
        db.close(ps);
        db.close(conn);
        return user;
    }
    
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
}


