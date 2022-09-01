package com.datit.dao;

import com.datit.connection.JDBCUtils;
import com.datit.model.Budget;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BudgetDao {
    //SQL statement CRUD
    private static final String SELECT_ALL = "SELECT * FROM budgets WHERE user_id = ?";
    private static final String INSERT_NEW = "INSERT INTO budgets(title,value,create_day,type,user_id) " +
            "VALUES(?,?,?,?,?)";
    private static final String DELETE_BY_ID = "DELETE FROM budgets WHERE id=? AND user_id=?";
    private static final String UPDATE_BY_ID = "UPDATE budgets SET " +
            "title = ?,value=?,create_day=?,type=? WHERE id=? AND user_id=?";
    private static final String SELECT_BY_USER_ID = "SELECT * FROM budgets WHERE user_id=?";
    //sql statement for calculate
    private static final String SUM_TOTAL_INCOME = "SELECT SUM(value) AS total_income FROM budgets" +
            " WHERE user_id = ? AND type = 1 AND MONTH(create_day) = ?";
    private static final String SUM_TOTAL_PAY = "SELECT SUM(value) AS total_pay FROM budgets" +
            " WHERE user_id = ? AND type = 2 AND MONTH(create_day) = ?";
    private static final String SUM_TOTAL_PLAN = "SELECT SUM(value) AS total_plan FROM budgets" +
            " WHERE user_id = ? AND type = 3 AND MONTH(create_day) = ?";
    private static final String SORT_BY_DATE = "SELECT * FROM budgets WHERE user_id=? AND create_day >= ?";


    public void insertNewBudget(Budget bg) {
        Connection cnt = JDBCUtils.getConnection();
        try {
            PreparedStatement ps = cnt.prepareStatement(INSERT_NEW);
            ps.setString(1, bg.getTitle());
            ps.setDouble(2, bg.getValue());
            ps.setDate(3, bg.getCreateDay());
            ps.setInt(4, bg.getType());
            ps.setInt(5, bg.getUser_id());
            JDBCUtils.showSQL(ps);
            ps.executeUpdate();
            cnt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Budget> selectAllByIdUser(int user_id, int month) {
        Connection cnt = JDBCUtils.getConnection();
        List<Budget> budgets = new ArrayList<Budget>();
        try {
            PreparedStatement ps = cnt.prepareStatement(SELECT_BY_USER_ID);
            ps.setInt(1, user_id);
            JDBCUtils.showSQL(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                double value = rs.getDouble("value");
                Date create_day = rs.getDate("create_day");
                int type = rs.getInt("type");
                Budget bg = new Budget(id, title, value, create_day, type, user_id);
                budgets.add(bg);
            }
            cnt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return budgets;
    }

    public int getTotalIncome(int user_id, int month) {
        double total = 0;
        Connection cnt = JDBCUtils.getConnection();
        try {
            PreparedStatement ps = cnt.prepareStatement(SUM_TOTAL_INCOME);
            ps.setInt(1, user_id);
            ps.setInt(2, month);
            JDBCUtils.showSQL(ps);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getDouble("total_income");
            }
            cnt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (int) total;
    }

    public int getTotalPay(int user_id, int month) {
        double total = 0;
        Connection cnt = JDBCUtils.getConnection();
        try {
            PreparedStatement ps = cnt.prepareStatement(SUM_TOTAL_PAY);
            ps.setInt(1, user_id);
            ps.setInt(2, month);
            JDBCUtils.showSQL(ps);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getDouble("total_pay");
            }
            cnt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (int) total;
    }

    public int getTotalPlan(int user_id, int month) {
        double total = 0;
        Connection cnt = JDBCUtils.getConnection();
        try {
            PreparedStatement ps = cnt.prepareStatement(SUM_TOTAL_PLAN);
            ps.setInt(1, user_id);
            ps.setInt(2, month);
            JDBCUtils.showSQL(ps);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getDouble("total_plan");
            }
            cnt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return (int) total;
    }

    public int getTotalValue(int user_id, int month) {
        return (int) (getTotalIncome(user_id, month) - getTotalPay(user_id, month));
    }

    public void removeBugdetByIdAndUser(int id, int user_id) {
        Connection cnt = JDBCUtils.getConnection();
        try {
            PreparedStatement ps = cnt.prepareStatement(DELETE_BY_ID);
            ps.setInt(1, id);
            ps.setInt(2, user_id);
            JDBCUtils.showSQL(ps);
            ps.executeUpdate();
            cnt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Budget> sortByDate(int user_id, Date daySort) {
        Connection cnt = JDBCUtils.getConnection();
        List<Budget> bg = new ArrayList<Budget>();
        try {
            PreparedStatement ps = cnt.prepareStatement(SORT_BY_DATE);
            ps.setInt(1, user_id);
            ps.setDate(2, daySort);
            JDBCUtils.showSQL(ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                double value = rs.getDouble("value");
                Date createDay = rs.getDate("create_day");
                int type = rs.getInt("type");
                Budget b = new Budget(id, title, value, createDay, type, user_id);
                bg.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bg;
    }

    public void setUpdateById(Budget bg) {
        Connection cnt = JDBCUtils.getConnection();
        try {
            PreparedStatement ps = cnt.prepareStatement(UPDATE_BY_ID);
            ps.setString(1, bg.getTitle());
            ps.setDouble(2, bg.getValue());
            ps.setDate(3, bg.getCreateDay());
            ps.setInt(4, bg.getType());
            ps.setInt(5, bg.getId());
            ps.setInt(6, bg.getUser_id());
            JDBCUtils.showSQL(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
