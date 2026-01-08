package com.auth.security;


import com.auth.entity.Role;
import com.auth.entity.User;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtUtil {

    private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(
            "MY_SECRET_KEY_123_MY_SECRET_KEY_123".getBytes() // must be 32+ chars
    );



    private final long EXPIRATION = 1000 * 60 * 60 * 24; // 24 hours

    public String generateToken(User user) {

        var roles = user.getRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.toList());

        var permissions = user.getRoles()
                .stream()
                .flatMap(role -> role.getPermissions().stream())
                .map(p -> p.getName())
                .collect(Collectors.toSet());

        return Jwts.builder()
                .subject(user.getUsername())
                .claim("roles", roles)
                .claim("permissions", permissions)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SECRET_KEY)
                .compact();
    }
}
