package com.datit.connection;

import com.datit.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCUtils {
    private static final String DB_URL="jdbc:mysql://us-cdbr-east-06.cleardb.net/heroku_9f7dcbdbf3bae87";
    private static final String USERNAME = "b8adc26ce80708";
    private static final String PASSWORD= "0af31a40";
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
