package com.example.kook.global.error;

import com.example.kook.global.error.exception.BaseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class GlobalExceptionFilter extends OncePerRequestFilter{

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            filterChain.doFilter(request, response);
        } catch (BaseException e) {
            response.setStatus(e.getErrorCode().getStatusCode());


            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json");

            ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode().getStatusCode(), e.getErrorCode().getErrorMessage());
            response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
        }
    }
}
