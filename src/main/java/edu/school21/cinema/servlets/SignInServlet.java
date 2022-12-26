package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;
import edu.school21.cinema.services.UsersService;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

        User user = usersService.findByEmail(request.getParameter("e-mail"), request.getParameter("password"));
        if (user == null) {
            response.sendRedirect("http://localhost:8080/");
        }
        HttpSession session = request.getSession();
        session.setAttribute("User", user);
//        PrintWriter pwriter = response.getWriter();
//        pwriter.println(session.getAttribute(("User")));
//        pwriter.println(session.isNew());
    }
}
