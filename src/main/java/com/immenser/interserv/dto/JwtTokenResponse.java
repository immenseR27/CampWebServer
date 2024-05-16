package com.immenser.interserv.dto;

public record JwtTokenResponse(
        String accessToken,
        String refreshToken
) {
}
