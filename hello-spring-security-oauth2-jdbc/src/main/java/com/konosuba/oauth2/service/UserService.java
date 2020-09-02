package com.konosuba.oauth2.service;

import com.konosuba.oauth2.domain.entity.User;

public interface UserService {
    public User getByUsername(String username);
}
