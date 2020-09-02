package com.konosuba.oauth2.service;

import com.konosuba.oauth2.domain.entity.Permission;

import java.util.List;

public interface PermissionService {
    public List<Permission> selectById(Long userId);
}
