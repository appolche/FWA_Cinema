package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/signUp", name = "SignUpServlet")
public class SignUpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        User user = new User();
        user.setEmail(request.getParameter("e-mail"));
        user.setFirstName(request.getParameter("first_name"));
        user.setLastName(request.getParameter("last_name"));
        user.setPhoneNumber(request.getParameter("phonenumber"));
        user.setPassword(request.getParameter("password"));
        //тут должен быть сервис, который будет обрабатывать полученные данные, заносить в базу, проверять на empty
    }
}


