package com.fitforge.fitforge_ai.controller;

import com.fitforge.fitforge_ai.common.ApiResponse;
import com.fitforge.fitforge_ai.common.ApiResponseUtil;
import com.fitforge.fitforge_ai.dto.request.LoginRequest;
import com.fitforge.fitforge_ai.dto.request.RefreshTokenRequest;
import com.fitforge.fitforge_ai.dto.request.UserRequest;
import com.fitforge.fitforge_ai.dto.response.LoginResponse;
import com.fitforge.fitforge_ai.dto.response.RefreshTokenResponse;
import com.fitforge.fitforge_ai.dto.response.UserResponse;
import com.fitforge.fitforge_ai.service.auth.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController
{
    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ApiResponse<LoginResponse> login(
            @RequestBody LoginRequest request){
        LoginResponse response =
                authenticationService.login(request);

        return ApiResponseUtil.success(
                "Login Successful",response
        );
    }

    @PostMapping("/register")
    public ApiResponse<UserResponse> register(
            @RequestBody @Valid UserRequest request) {

        UserResponse response =
                authenticationService.register(request);

        return ApiResponseUtil.success(
                "User Registered Successfully",
                response
        );
    }

    @PostMapping("/refresh")
    public ApiResponse<RefreshTokenResponse> refreshToken(
            @RequestBody RefreshTokenRequest request){
        return ApiResponseUtil.success("Access Token Generated Successfully",
                 authenticationService.refreshToken(request));
    }
}
