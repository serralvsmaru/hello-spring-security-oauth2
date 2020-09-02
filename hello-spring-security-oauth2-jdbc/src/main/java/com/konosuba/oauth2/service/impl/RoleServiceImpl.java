package com.konosuba.oauth2.service.impl;

import com.konosuba.oauth2.mapper.RoleMapper;
import com.konosuba.oauth2.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;
}
