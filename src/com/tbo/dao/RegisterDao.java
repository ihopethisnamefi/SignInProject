package com.tbo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

public class RegisterDao {
	
    public static void insert(String name, String fullname, String pass, String salt) {        
        Connection conn = null;
        PreparedStatement pst = null;
        int rs;

        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "test";
        String driver = "com.mysql.jdbc.Driver";
        String userName = ""; //Note: removed user/password from public view
        String password = "";
   
        
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager
                    .getConnection(url + dbName, userName, password);

            pst = conn
                    .prepareStatement("insert into users values (?,?,?,?)");
                      
            pst.setString(1, fullname);
            pst.setString(2, name);
            pst.setString(3, pass);
            pst.setString(4, salt);

            rs = pst.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            /*
            if (rs != 0) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }*/
        }
    }

}
