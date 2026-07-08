package com.fitforge.fitforge_ai.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RefreshTokenResponse
{
    private String accessToken;
    private String refreshToken;
    private String tokenType;
}
