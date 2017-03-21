/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jackie.springmvc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author zz
 */
public class DBConnection {
    static String user = "root";
    static String password = "adminzyl_63";
    static String driveName = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/jd";
    
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    static{
        try {
            //注册驱动
            Class.forName(driveName);
        } catch (ClassNotFoundException e) {
            System.out.println("注册驱动异常:"+ e.getMessage());
        }
    } 
    
    
    public Connection getConnection() throws SQLException{
        conn = DriverManager.getConnection(url,user,password);
        return conn;
    }
    
    public void close(Connection conn){
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            System.out.println("关闭数据库连接异常：" + e.getMessage());
        }
    }
    
    public void close(PreparedStatement ps){
        try {
            if (ps != null) {
                ps.close();
                ps = null;
            }
        } catch (SQLException e) {
            System.out.println("关闭prepared statement异常：" + e.getMessage());
        }
    }
    
    public void close(ResultSet rs){
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (SQLException e) {
            System.out.println("关闭ResutltSet异常：" + e.getMessage());
        }
    }
    
}
