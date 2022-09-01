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
import java.time.LocalDate;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/quan-ly"})
public class QuanLy extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        try {
            if (session.getAttribute("username") != null) {
                BudgetDao dao = new BudgetDao();
                int month = 0;
                if (req.getParameter("month") == null) {
                    month = LocalDate.now().getMonthValue();
                } else {
                    month = Integer.parseInt(req.getParameter("month"));
                }
                int user_id = (Integer) session.getAttribute("user_id");
                req.setAttribute("total_income", dao.getTotalIncome(user_id, month));
                req.setAttribute("total_pay", dao.getTotalPay(user_id, month));
                req.setAttribute("total_plan", dao.getTotalPlan(user_id, month));
                req.setAttribute("total", dao.getTotalValue(user_id,month));
                req.setAttribute("month_request",month);
                req.getRequestDispatcher(PageRedirect.DASHBOARD_PAGE).forward(req, resp);
            } else {
                req.getRequestDispatcher(PageRedirect.LOGIN_PAGE).forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
