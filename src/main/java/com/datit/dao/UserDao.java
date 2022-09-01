package com.datit.dao;

import com.datit.connection.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    private static final String VALIDATE = "SELECT * FROM users" +
            " WHERE username = ? AND password = ?";
    private static final String INSERT_NEW_ACCOUNT = "INSERT INTO users(username,password)" + "VALUES(?,?)";
    private static final String SELECT_ID_BY_USERNAME = "SELECT id FROM users WHERE username = ?";
    public boolean validateAccount(String username, String password) {
        Connection cnt = JDBCUtils.getConnection();
        boolean success = false;
        try {
            PreparedStatement ps = cnt.prepareStatement(VALIDATE);
            ps.setString(1, username);
            ps.setString(2, password);
            JDBCUtils.showSQL(ps);
            ResultSet rs = ps.executeQuery();
            success = rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    public boolean insertNewUser(String username, String password) {
        boolean success = false;
        Connection cnt = JDBCUtils.getConnection();
        try {
            PreparedStatement ps = cnt.prepareStatement(INSERT_NEW_ACCOUNT);
            ps.setString(1, username);
            ps.setString(2, password);
            success = ps.executeUpdate() > 0;
            JDBCUtils.showSQL(ps);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }
    public int selectIdByUsername(String username) {
        int user_id = 0;
        Connection cnt = JDBCUtils.getConnection();
        try {
            PreparedStatement ps = cnt.prepareStatement(SELECT_ID_BY_USERNAME);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user_id = rs.getInt("id");
            }
            JDBCUtils.showSQL(ps);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user_id;
    }
}
