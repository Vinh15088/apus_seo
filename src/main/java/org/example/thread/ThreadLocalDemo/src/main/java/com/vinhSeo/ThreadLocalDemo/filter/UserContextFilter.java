package org.example.thread.ThreadLocalDemo.src.main.java.com.vinhSeo.ThreadLocalDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.example.thread.ThreadLocalDemo.src.main.java.com.vinhSeo.ThreadLocalDemo.context.UserContext;
import org.example.thread.ThreadLocalDemo.src.main.java.com.vinhSeo.ThreadLocalDemo.util.JwtUtil;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UserContextFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            String token = httpServletRequest.getHeader("Authorization");

            String userId = JwtUtil.extractUserId(token);

            if(userId != null) {
                UserContext.setUserId(userId);
            }

            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            UserContext.clear();
        }
    }
}
