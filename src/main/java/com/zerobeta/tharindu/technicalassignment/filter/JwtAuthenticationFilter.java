package com.zerobeta.tharindu.technicalassignment.filter;

import com.zerobeta.tharindu.technicalassignment.utils.JwtDecoder;
import com.zerobeta.tharindu.technicalassignment.utils.JwtToSecurityUserConverter;
import com.zerobeta.tharindu.technicalassignment.utils.SecurityUserAuthenticationToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter  extends OncePerRequestFilter {
    private final JwtDecoder jwtDecoder;
    private final JwtToSecurityUserConverter jwtToSecurityUserConverter;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull FilterChain filterChain) throws ServletException, IOException {
        extractToken(request)
                .map(jwtDecoder::decode)
                .map(jwtToSecurityUserConverter::convert)
                .map(SecurityUserAuthenticationToken::new)
                .ifPresent(authentication -> SecurityContextHolder.getContext().setAuthentication(authentication));

        filterChain.doFilter(request, response);
    }

    private Optional<String> extractToken(HttpServletRequest request){
        var token = request.getHeader("Authorization");
        if (StringUtils.hasText(token) && token.startsWith("Bearer")){
            return Optional.of(token.substring(7));
        }
        return Optional.empty();
    }
}
