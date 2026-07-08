package com.fitforge.fitforge_ai.controller;

import com.fitforge.fitforge_ai.common.ApiResponse;
import com.fitforge.fitforge_ai.common.ApiResponseUtil;
import com.fitforge.fitforge_ai.dto.request.UserRequest;
import com.fitforge.fitforge_ai.dto.response.UserResponse;
import com.fitforge.fitforge_ai.entity.User;
import com.fitforge.fitforge_ai.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController
{
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    //Create User
//    @PostMapping
//    public ApiResponse<UserResponse> createUser(@Valid @RequestBody UserRequest request){
//        UserResponse response = service.createUser(request);
//        return ApiResponseUtil.success(
//                "User Created Successfully",response
//        );
//    }

    //Get all users
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<List<UserResponse>> getAllUsers(){
        List<UserResponse> users = service.getAllUsers();
        return ApiResponseUtil.success(
                "User Fetched Successfully",users
        );
    }

    //Get User By Id
    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getUserById(@PathVariable Long id) {

        UserResponse user = service.getUserById(id);

        return ApiResponseUtil.success(
                "User fetched successfully",
                user
        );
    }

    //Update user
    @PutMapping("/{id}")
    public ApiResponse<UserResponse> updateUser(
            @Valid
            @PathVariable Long id,
            @RequestBody UserRequest request) {

        UserResponse response = service.updateUser(id, request);

        return ApiResponseUtil.success(
                "User updated successfully",
                response
        );
    }

    //Delete user
    @DeleteMapping("{id}")
    public ApiResponse<Void> deleteUser(@PathVariable Long id) {

        service.deleteUser(id);

        return ApiResponseUtil.success(
                "User deleted successfully",
                null
        );
    }
}
