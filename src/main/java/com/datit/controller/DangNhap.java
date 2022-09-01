package com.datit.controller;

import com.datit.dao.UserDao;
import com.datit.model.Budget;
import com.datit.variable.PageRedirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/dang-nhap"})
public class DangNhap extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try {
            HttpSession session = req.getSession();
            if (session.getAttribute("username") == null) {
                req.getRequestDispatcher(PageRedirect.LOGIN_PAGE).forward(req, resp);
            } else req.getRequestDispatcher(PageRedirect.DASHBOARD_PAGE).forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try {
            HttpSession session = req.getSession();
            if (session.getAttribute("username") == null) {
                UserDao dao = new UserDao();
                String username = String.valueOf(req.getParameter("username"));
                String password = String.valueOf(req.getParameter("password"));
                if(dao.validateAccount(username,password)){
                    session.setAttribute("username",username);
                    session.setAttribute("user_id",dao.selectIdByUsername(username));
                    resp.sendRedirect(req.getContextPath()+"/quan-ly");
                }else{
                    req.setAttribute("notify",false);
                    req.getRequestDispatcher(PageRedirect.LOGIN_PAGE).forward(req,resp);
                }
            } else {
                req.getRequestDispatcher(PageRedirect.DASHBOARD_PAGE).forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
