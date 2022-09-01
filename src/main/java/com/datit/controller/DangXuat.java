package com.datit.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/dang-xuat"})
public class DangXuat extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        try{
            HttpSession session = req.getSession();
            if(session.getAttribute("username")!=null){
                session.invalidate();
            }
            resp.sendRedirect(req.getContextPath()+"/trang-chu");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
