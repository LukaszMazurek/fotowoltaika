package com.example.fotowoltaika.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetails;


@Component
public class JwtUtils {

    @Value("test")
    private String jwtCookie;


    public ResponseCookie getCleanJwtCookie() {
        ResponseCookie cookie = ResponseCookie.from(jwtCookie, null).path("/api").build();
        return cookie;
    }


}
