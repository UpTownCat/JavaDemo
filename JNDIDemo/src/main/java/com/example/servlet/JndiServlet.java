package com.example.servlet;

import com.example.bean.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/8/26.
 */
public class JndiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context = null;
        try {
            context = new InitialContext();
            Context evContext = (Context) context.lookup("java:comp/env");
            User user = (User) evContext.lookup("user");
            PrintWriter writer = resp.getWriter();
            writer.println(user);
            writer.close();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
