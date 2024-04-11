package com.zerobeta.tharindu.technicalassignment.utils;

import com.zerobeta.tharindu.technicalassignment.model.SecurityUser;
import org.springframework.security.authentication.AbstractAuthenticationToken;

import java.util.Collections;

public class SecurityUserAuthenticationToken extends AbstractAuthenticationToken {
    private final SecurityUser securityUser;
    public SecurityUserAuthenticationToken(SecurityUser securityUser) {
        super(Collections.emptyList());
        this.securityUser = securityUser;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return securityUser;
    }
}
