package edu.school21.cinema.servlets;

import edu.school21.cinema.models.User;
import edu.school21.cinema.services.ImageService;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fwa/images")
public class ImageServlet extends HttpServlet {
    private ImageService imageService;

    @Override
    public void init(ServletConfig config) {
        ServletContext context = config.getServletContext();
        ApplicationContext springContext = (ApplicationContext) context.getAttribute("springContext");
        this.imageService = springContext.getBean(ImageService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        for (String imagePath : imageService.getImages()) {
//            req.getSession().setAttribute(imagePath, new Object());
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!ServletFileUpload.isMultipartContent(req)) {
            throw new ServletException("not multipart content");
        }
        User currentUser = (User) req.getSession().getAttribute("User");

        resp.getWriter().println(imageService.uploadImage(req, currentUser.getId()) + System.getProperty("catalina.home"));
    }
}
