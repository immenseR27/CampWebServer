package com.immenser.interserv.security;

public class JwtException extends RuntimeException{
    public JwtException(String message) {
        super(message);
    }
}