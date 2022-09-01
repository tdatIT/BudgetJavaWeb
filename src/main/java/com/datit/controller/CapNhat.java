package com.datit.controller;

import com.datit.dao.BudgetDao;
import com.datit.model.Budget;
import com.datit.variable.PageRedirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet(urlPatterns = {"/update-data"})
public class CapNhat extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try {
            HttpSession session = req.getSession();
            if (session.getAttribute("username") != null) {
                int user_id = (int) session.getAttribute("user_id");
                //get data from form
                int id = Integer.parseInt(req.getParameter("edit-id"));
                String title = req.getParameter("edit-title");
                double value = Double.parseDouble(req.getParameter("edit-value"));
                int type = Integer.parseInt(req.getParameter("edit-type"));
                Date createDay = Date.valueOf(req.getParameter("edit-date"));
                BudgetDao dao = new BudgetDao();
                Budget bg = new Budget(id, title, value, createDay, type, user_id);
                dao.setUpdateById(bg);
            } else {
                req.getRequestDispatcher(PageRedirect.LOGIN_PAGE).forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
