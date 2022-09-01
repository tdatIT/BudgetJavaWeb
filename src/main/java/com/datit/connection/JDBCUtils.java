package com.datit.connection;

import com.datit.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCUtils {
    private static final String DB_URL="jdbc:mysql://localhost:3306/budget_java_web";
    private static final String USERNAME = "root";
    private static final String PASSWORD= "123456";
    public static Connection getConnection() {
        Connection cnt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnt = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnt;
    }
    public static void showSQL(PreparedStatement ps){
        System.out.println(ps);
    }
}
