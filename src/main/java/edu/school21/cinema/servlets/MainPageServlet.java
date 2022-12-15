package edu.school21.cinema.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = {"/", "/users/sign_up"}, name = "MainPageServlet")
public class MainPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        String path = req.getServletPath();
        if (path.equals("/")) {
            req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
        } else if (path.equals("/users/sign_up")) {
            req.getRequestDispatcher("/WEB-INF/jsp/sign_up.jsp").forward(req, resp);
        }
    }
}
