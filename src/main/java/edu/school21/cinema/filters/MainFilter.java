package edu.school21.cinema.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class MainFilter implements Filter {
    private static final String PROFILE_CONTEXT = "/profile";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String currentUrl = req.getRequestURI();
        boolean isUserAuth = req.getSession().getAttribute("User") != null;

        if ("/profile".equals(currentUrl) && !isUserAuth) {
            resp.sendError(403);
        }
        if (isUserAuth && ("/signIn".equals(currentUrl) || "/signUp".equals(currentUrl))) {
            resp.sendRedirect(PROFILE_CONTEXT);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
