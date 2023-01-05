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

        if ("/profile".equals(currentUrl)) {
            if (req.getSession().getAttribute("User") == null) {
                resp.sendError(403);
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else if ("/signIn".equals(currentUrl) || "/signUp".equals(currentUrl)) {
            if (req.getSession().getAttribute("User") == null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                resp.sendRedirect(PROFILE_CONTEXT);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}

