package edu.school21.cinema.servlets;

import edu.school21.cinema.models.SignInRequestEntity;
import edu.school21.cinema.services.UsersService;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/sign_in", name = "SignInServlet")
public class SignInServlet extends HttpServlet {
    private UsersService usersService;

    @Override
    public void init(ServletConfig config) {
        ServletContext context = config.getServletContext();
        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
        this.usersService = springContext.getBean(UsersService.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

//        String password = request.getParameter("password");
        SignInRequestEntity signInRequestEntity = usersService.findByEmail(request.getParameter("e-mail"));
        if (signInRequestEntity == null) {
            response.sendRedirect("http://localhost:8080/");
        }
        PrintWriter printWriter = response.getWriter();
        printWriter.println(signInRequestEntity);

//        signInRequestEntity.getPassword() == request.getParameter("password");
    }
}
