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
import java.util.List;

@WebServlet(urlPatterns = {"/add-data"})
public class Them extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try {
            HttpSession session = req.getSession();
            if (session.getAttribute("username") != null) {
                BudgetDao dao = new BudgetDao();
                //Get data from session and form
                int user_id = (int)session.getAttribute("user_id");
                String title = (String)req.getParameter("title-add");
                double value = Double.parseDouble(req.getParameter("value-add"));
                Date create_day = Date.valueOf(req.getParameter("day-add"));
                int type = Integer.parseInt(req.getParameter("type-add"));
                //Pass into bg variable
                Budget bg = new Budget(title,value,create_day,type,user_id);
                dao.insertNewBudget(bg);
                resp.sendRedirect(req.getContextPath()+PageRedirect.TABLE_SERVLET);
            } else {
                req.getRequestDispatcher(PageRedirect.LOGIN_PAGE).forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

