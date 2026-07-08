package com.fitforge.fitforge_ai.service;

import com.fitforge.fitforge_ai.dto.request.UserRequest;
import com.fitforge.fitforge_ai.dto.response.UserResponse;
import com.fitforge.fitforge_ai.entity.User;

import java.util.List;

public interface UserService
{
    UserResponse createUser(UserRequest request);
    List<UserResponse> getAllUsers();
    UserResponse getUserById(Long id);
    UserResponse updateUser(Long id, UserRequest request);
    void deleteUser(Long id);
}
