package com.example.WeatherServer.Configuration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Component;

@Component
public class MySecurityContextRepository implements SecurityContextRepository {

    private static final String SPRING_SECURITY_CONTEXT_KEY = HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

    @Override
    public SecurityContext loadContext(HttpRequestResponseHolder requestResponseHolder) {
        HttpServletRequest request = requestResponseHolder.getRequest();
        HttpServletResponse response = requestResponseHolder.getResponse();

        SecurityContext context = (SecurityContext) request.getSession().getAttribute(SPRING_SECURITY_CONTEXT_KEY);
        if (context == null) {
            context = SecurityContextHolder.createEmptyContext();
        }
        return context;
    }




    @Override
    public void saveContext(SecurityContext context, HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute(SPRING_SECURITY_CONTEXT_KEY, context);
    }

    @Override
    public boolean containsContext(HttpServletRequest request) {
        return request.getSession().getAttribute(SPRING_SECURITY_CONTEXT_KEY) != null;
    }
}
