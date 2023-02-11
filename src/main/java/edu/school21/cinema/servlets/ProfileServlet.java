package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;
import edu.school21.cinema.services.ImageService;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/profile")
@MultipartConfig
public class ProfileServlet extends HttpServlet {
    private ImageService imageService;
    private static final String PROFILE_HTML = "/WEB-INF/jsp/profile.jsp";

    @Override
    public void init(ServletConfig config) {
        ServletContext context = config.getServletContext();
        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
        this.imageService = springContext.getBean(ImageService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");


//        List<Image> userImages = imageService.getImages(user.getId());
//        session.setAttribute("files", userImages);
//
//        List<SessionService.SessionDto> sessions = sessionService.getSessions(user);
//        session.setAttribute("sessions", sessions);

        request.getRequestDispatcher(PROFILE_HTML).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (!ServletFileUpload.isMultipartContent(request)) {
            throw new ServletException("not multipart content");
        }

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("User");

        response.getWriter().println(imageService
                .uploadImage(request, user.getId()) + System.getProperty("catalina.home"));
    }

}
