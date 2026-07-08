package com.fitforge.fitforge_ai.service.auth;

import com.fitforge.fitforge_ai.dto.request.LoginRequest;
import com.fitforge.fitforge_ai.dto.request.RefreshTokenRequest;
import com.fitforge.fitforge_ai.dto.request.UserRequest;
import com.fitforge.fitforge_ai.dto.response.LoginResponse;
import com.fitforge.fitforge_ai.dto.response.RefreshTokenResponse;
import com.fitforge.fitforge_ai.dto.response.UserResponse;

public interface AuthenticationService
{
    LoginResponse login(LoginRequest request);
    UserResponse register(UserRequest request);
    RefreshTokenResponse refreshToken(RefreshTokenRequest request);
}
