package com.nocountry.inmuebles.jwt;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;


    @Autowired
    private CustomerDetailsService customerDetailsService;

    private String username=null;

    Claims claims =null;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        System.out.println("ENTRO al doFilter internal");
        if(request.getServletPath().matches("/user/login|/user/forgotPassword|/user/save|/property/all|/province|/city/.*|/correo/.*|/property/filter|/property_type|/property/findById/.*")){
            filterChain.doFilter(request, response);
        }
        else{
            System.out.println("el token es : " + request);
            String authorizationHeader = request.getHeader("Authorization");
            String token = null;
            System.out.println("Hola estoy aca");
            System.out.println(authorizationHeader);
            if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer ")){
                token = authorizationHeader.substring(7);
                username = jwtUtil.extractUserName(token);
                claims = jwtUtil.extractAllClaims(token);
            }

            if(username != null && SecurityContextHolder.getContext().getAuthentication()==null){
                UserDetails userDetails = customerDetailsService.loadUserByUsername(username);
                if(jwtUtil.validateToken(token, userDetails)){
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
            filterChain.doFilter(request, response);
        }
    }

    public Boolean isClient(){
        return "client".equalsIgnoreCase((String)claims.get("role"));
    }
    public Boolean isSeller(){
        return "seller".equalsIgnoreCase((String)claims.get("role"));
    }

    public String getCurrentUser(){
        return username;
    }

}
