package com.fitforge.fitforge_ai.service.impl;

import com.fitforge.fitforge_ai.dto.request.UserRequest;
import com.fitforge.fitforge_ai.dto.response.UserResponse;
import com.fitforge.fitforge_ai.entity.User;
import com.fitforge.fitforge_ai.exception.EmailAlreadyExistsException;
import com.fitforge.fitforge_ai.exception.UserNotFoundException;
import com.fitforge.fitforge_ai.mapper.UserMapper;
import com.fitforge.fitforge_ai.repository.UserRepository;
import com.fitforge.fitforge_ai.service.UserService;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.repo = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponse createUser(UserRequest request) {

        if (repo.findByEmail(request.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        User user = UserMapper.toEntity(request);

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setRole("USER");

        User savedUser = repo.save(user);

        return UserMapper.toResponse(savedUser);
    }

    @Override
    public List<UserResponse> getAllUsers() {

        List<User> users = repo.findAll();
        return users.stream()
                .map(UserMapper::toResponse)
                .toList();
    }

    @Override
    public UserResponse getUserById(Long id) {
        User user = repo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return UserMapper.toResponse(user);
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest request) {
        User existingUser = repo.findById(id)
                        .orElseThrow(() -> new UserNotFoundException("User not found"));

        existingUser.setFirstName(request.getFirstName());
        existingUser.setLastName(request.getLastName());
        existingUser.setPhone(request.getPhone());

        User updatedUser = repo.save(existingUser);

        return UserMapper.toResponse(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = repo.findById(id)
                        .orElseThrow(() -> new UserNotFoundException("User not found"));

        repo.delete(user);
    }
}
