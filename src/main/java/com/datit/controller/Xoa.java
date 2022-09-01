package com.datit.controller;

import com.datit.dao.BudgetDao;
import com.datit.variable.PageRedirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/remove-data"})
public class Xoa extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try{
            HttpSession session = req.getSession();
            if(session.getAttribute("username")!=null){
                int user_id = (int)session.getAttribute("user_id");
                int budget_id =Integer.parseInt(req.getParameter("remove-id"));
                BudgetDao dao = new BudgetDao();
                dao.removeBugdetByIdAndUser(budget_id,user_id);
            }
        }catch (Exception e){
            e.printStackTrace();
            req.getRequestDispatcher(PageRedirect.LOGIN_PAGE).forward(req,resp);
        }
    }
}
