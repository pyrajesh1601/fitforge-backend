package com.fitforge.fitforge_ai.mapper;

import com.fitforge.fitforge_ai.dto.request.UserRequest;
import com.fitforge.fitforge_ai.dto.response.UserResponse;
import com.fitforge.fitforge_ai.entity.User;

public class UserMapper
{
    private UserMapper(){
       }
    public static User toEntity(UserRequest request)
    {
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .phone(request.getPhone())
                .build();
    }

    public static UserResponse toResponse(User user)
    {
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .build();
    }

}

