package edu.school21.cinema.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/", "/profile"})
public class MainFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if (req.getSession().getAttribute("User") == null) {
            HttpServletResponse resp = (HttpServletResponse) servletResponse;
            resp.sendError(403);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
