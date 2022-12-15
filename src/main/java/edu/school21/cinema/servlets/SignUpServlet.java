package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;
import edu.school21.cinema.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/sign_up", name = "SignUpServlet")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        User user = new User();
        user.setEmail(request.getParameter("e-mail"));
        user.setFirstName(request.getParameter("first_name"));
        user.setLastName(request.getParameter("last_name"));
        user.setPhoneNumber(request.getParameter("phone_number"));
        user.setPassword(request.getParameter("password"));

        response.getWriter().println(user.getEmail());
        response.getWriter().println(user.getPassword());
        response.getWriter().println(user.getFirstName());
        response.getWriter().println(user.getLastName());
        response.getWriter().println(user.getPhoneNumber());

        //тут должен быть сервис, который будет обрабатывать полученные данные, заносить в базу, проверять на empty
    }
}
