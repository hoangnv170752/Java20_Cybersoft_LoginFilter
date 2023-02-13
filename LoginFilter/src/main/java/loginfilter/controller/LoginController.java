package loginfilter.controller;
import loginfilter.model.*;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static loginfilter.constant.Constant.*;
@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var userName = req.getParameter("username");
        var password = req.getParameter("password");
        var user = new UserModel().getUser(userName, password);
        if (user != null) {
            addSession(req, SESSION_LOGIN, userName, 60);
            resp.sendRedirect(req.getContextPath() + "/welcome");
        } else {
            req.setAttribute("checkLogin", "failed");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    private void addSession(HttpServletRequest req, String name, String value, int interval) {
        var session = req.getSession();
        session.setAttribute(name, value);
        session.setMaxInactiveInterval(interval);
    }
}
