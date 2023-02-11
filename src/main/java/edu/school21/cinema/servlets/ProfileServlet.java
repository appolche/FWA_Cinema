package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;
import edu.school21.cinema.models.Image;
import edu.school21.cinema.services.ImageService;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private ImageService imageService;
    private static final String PROFILE_HTML = "/WEB-INF/jsp/profile.jsp";

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
        User user = (User) session.getAttribute("user");

        response.getWriter().println(imageService.uploadImage(request, user.getId()) + System.getProperty("catalina.home"));
    }

}
