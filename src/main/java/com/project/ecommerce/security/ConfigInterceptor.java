package com.project.ecommerce.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigInterceptor implements HandlerInterceptor {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ANONYMOUS"))) {
            CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();
            request.setAttribute("user_fullName", principal.getUser().getFullName());
            request.setAttribute("user_phone", principal.getUser().getPhone());
            request.setAttribute("user_email", principal.getUser().getEmail());
            request.setAttribute("user_address", principal.getUser().getAddress());
            request.setAttribute("isLogin", true);
        } else {
            request.setAttribute("isLogin", false);
        }
    }
}
