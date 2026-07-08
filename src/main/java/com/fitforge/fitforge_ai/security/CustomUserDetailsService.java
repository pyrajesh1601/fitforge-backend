package com.fitforge.fitforge_ai.security;

import com.fitforge.fitforge_ai.repository.UserRepository;
import com.fitforge.fitforge_ai.entity.User;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
    private final UserRepository repo;

    public CustomUserDetailsService(UserRepository repo){
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        User user = repo.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User Not Found"));

        System.out.println("Email : " + user.getEmail());
        System.out.println("Role  : " + user.getRole());

        return new UserPrincipal(user);
    }
}
