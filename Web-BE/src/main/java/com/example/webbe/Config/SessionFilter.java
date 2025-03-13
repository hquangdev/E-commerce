package com.example.webbe.Config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;

@Component
public class SessionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        boolean hasSessionId = false;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("sessionId".equals(cookie.getName())) {
                    hasSessionId = true;
                    break;
                }
            }
        }

        // Nếu không có sessionId, tạo mới và gửi về trình duyệt
        if (!hasSessionId) {
            String sessionId = UUID.randomUUID().toString();
            Cookie sessionCookie = new Cookie("sessionId", sessionId);
            sessionCookie.setPath("/");
            sessionCookie.setHttpOnly(true); // Không cho frontend truy cập (bảo mật hơn)
            sessionCookie.setMaxAge(7 * 24 * 60 * 60);
            response.addCookie(sessionCookie);
        }

        filterChain.doFilter(request, response);
    }


}


