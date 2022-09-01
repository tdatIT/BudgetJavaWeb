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

@WebServlet(urlPatterns = {"/sort-day"})
public class SortDay extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        try{
            Date day_request = Date.valueOf(req.getParameter("date-sort"));
            if(day_request != null && session.getAttribute("username")!=null){
                BudgetDao dao = new BudgetDao();
                int user_id = (int)session.getAttribute("user_id");
                List<Budget> data = dao.sortByDate(user_id,day_request);
                req.setAttribute("data",data);
                req.getRequestDispatcher(PageRedirect.TABLE_DATA).forward(req,resp);
            }
            else{
                resp.sendRedirect(req.getContextPath()+PageRedirect.TABLE_SERVLET);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
