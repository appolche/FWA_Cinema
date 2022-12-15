package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/sign_in", name = "SignInServlet")
public class SignInServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        //мб принимать в отдельные стринги?
        User user = new User();
        user.setEmail(request.getParameter("e-mail"));
        user.setPassword(request.getParameter("password")); //защита?
        //тут должен быть сервис, который будет обрабатывать полученные данные, ходить в базу и чекать корректность
    }
}
