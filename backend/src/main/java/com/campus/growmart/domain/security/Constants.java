package com.campus.growmart.domain.security;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;

public class Constants {

    // Spring Security
    public static final String[] AUTH = { "/login", "/register" };
    public static final String[] SWAGGER = {
            "/doc/**",
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/api/v1/auth/**",
            "/v2/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-ui.html" };
    public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
    public static final String TOKEN_BEARER_PREFIX = "Bearer ";

    // JWT
    public static final String SUPER_SECRET_KEY = "VGhpcyBpcyBhIG5vdGUgdG8gdGV4dC4gVGhpcyBlbmNvZGluZyBpcyBhIG5lZWQgdGV4dC4gVGhpcyBpcyBhIG5lZWQgdGV4dC4=";

    public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day

    /**
     * Genera una clave para firmar o verificar tokens JWT a partir de un secreto
     * proporcionado,
     * interpretado como una representación en base64 del secreto.
     * 
     * @param secret El secreto en formato base64.
     * @return La clave generada para HMAC-SHA.
     */
    public static Key getSigningKeyB64(String secret) {
        // Decodifica el secreto desde su representación en base64 a bytes
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        // Crea una instancia de clave HMAC-SHA utilizando los bytes decodificados
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * Genera una clave para firmar o verificar tokens JWT a partir de un secreto
     * proporcionado,
     * interpretado como una cadena de caracteres.
     * 
     * @param secret El secreto como una cadena de caracteres.
     * @return La clave generada para HMAC-SHA.
     */
    public static Key getSigningKey(String secret) {
        // Obtiene los bytes del secreto utilizando la codificación UTF-8
        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);
        // Crea una instancia de clave HMAC-SHA utilizando los bytes obtenidos
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
