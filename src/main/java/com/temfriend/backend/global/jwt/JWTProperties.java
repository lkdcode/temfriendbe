package com.temfriend.backend.global.jwt;

import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

@ConfigurationProperties(prefix = "app.jwt")
@Getter
@Setter
public class JWTProperties {
    private String issuer;
    private String secretKey;
    private String expired;

    public Key getSecretKey() {
        byte[] keyBytes = DatatypeConverter.parseBase64Binary(secretKey);
        return new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());
    }

    public Long getExpired() {
        return Long.parseLong(expired);
    }
}
