package com.fitforge.fitforge_ai.service;

import com.fitforge.fitforge_ai.entity.RefreshToken;
import com.fitforge.fitforge_ai.entity.User;

public interface RefreshTokenService
{
    RefreshToken createRefreshToken(User user);
    RefreshToken verifyExpiration(RefreshToken token);
    RefreshToken findByToken(String token);
    void deleteByUser(User user);
}
