package com.temfriend.backend.global.security.cookie;

import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Service
public class CookieProvider {
    private static final String PATH = "/";
    private static final String ENC = "UTF-8";
    private static final int MAX_AGE = 60 * 60;

    public String findCookieByKey(HttpServletRequest httpServletRequest, String key) {
        try {
            Cookie[] cookies = httpServletRequest.getCookies();

            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(key)) {
                    String decode = URLDecoder.decode(cookie.getValue(), ENC);
                    System.out.println(decode);
                    return decode;
                }
            }
            return null;
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public void addCookieKeyAndValue(HttpServletResponse httpServletResponse, String key, String value) {
        try {
            Cookie cookie = new Cookie(key, URLEncoder.encode(value, ENC));
            cookie.setPath(PATH);
            cookie.setMaxAge(MAX_AGE);
            cookie.setHttpOnly(true);
            httpServletResponse.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
