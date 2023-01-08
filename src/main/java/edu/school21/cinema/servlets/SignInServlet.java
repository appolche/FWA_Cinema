package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;
import edu.school21.cinema.services.UsersService;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/signIn", name = "SignInServlet")
public class SignInServlet extends HttpServlet {
    private UsersService usersService;
    private static final String URL_ROOT = "/";
    private static final String URL_PROFILE = "/profile";
    private static final String SIGN_IN_HTML = "/WEB-INF/html/sign_in.html";

    @Override
    public void init(ServletConfig config) {
        ServletContext context = config.getServletContext();
        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
        this.usersService = springContext.getBean(UsersService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(SIGN_IN_HTML).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        User user = usersService.findByEmail(request.getParameter("e-mail"), request.getParameter("password"));
        if (user == null) {
            response.sendRedirect(URL_ROOT);
            return;
        }
        HttpSession session = request.getSession();
        session.setAttribute("User", user);
        response.sendRedirect(URL_PROFILE);
    }
}
