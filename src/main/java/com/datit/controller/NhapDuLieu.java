package com.datit.controller;

import com.datit.dao.BudgetDao;
import com.datit.model.Budget;
import com.datit.variable.PageRedirect;

import javax.ejb.Local;
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

@WebServlet(urlPatterns = {PageRedirect.TABLE_SERVLET})
public class NhapDuLieu extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        try{
            if(session.getAttribute("username")!=null){
                Date current_day = Date.valueOf(LocalDate.now());
                BudgetDao dao = new BudgetDao();
                int user_id = (int)session.getAttribute("user_id");
                req.setAttribute("current_day",current_day);
                req.setAttribute("data",dao.sortByDate(user_id,current_day));
                req.getRequestDispatcher(PageRedirect.TABLE_DATA).forward(req,resp);
            }
            else{
                req.getRequestDispatcher(PageRedirect.LOGIN_PAGE).forward(req,resp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
