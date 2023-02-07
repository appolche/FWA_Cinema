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
import java.io.IOException;

@WebServlet("/images")
@MultipartConfig
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
        User user = (User) req.getSession().getAttribute("User");
//        PrintWriter printWriter = resp.getWriter();
//        for (String str : ) {
//            printWriter.println(str);
//        }

        imageService.getImages(user.getId(), resp);
//        ServletOutputStream sos = resp.getOutputStream();
//        BufferedOutputStream bos = new BufferedOutputStream(sos);
//
//        FileInputStream fis = new FileInputStream("path");
//        BufferedInputStream bis = new BufferedInputStream(fis);
//
//        int ch;
//        while ((ch = bis.read()) != -1) {
//            bos.write(ch);
//        }
//        bis.close();
//        fis.close();
//        bos.close();
//        sos.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!ServletFileUpload.isMultipartContent(req)) {
            throw new ServletException("not multipart content");
        }
        User currentUser = (User) req.getSession().getAttribute("User");
        imageService.uploadImage(req, currentUser.getId());
        resp.sendRedirect("/profile");
    }
}
