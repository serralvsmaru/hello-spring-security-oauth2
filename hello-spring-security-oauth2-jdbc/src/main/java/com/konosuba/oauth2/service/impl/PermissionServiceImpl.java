package com.konosuba.oauth2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.konosuba.oauth2.domain.entity.Permission;
import com.konosuba.oauth2.mapper.PermissionMapper;
import com.konosuba.oauth2.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> selectById(Long userId) {
        QueryWrapper<Permission> qw = new QueryWrapper<>();
        qw.eq(Permission.COL_ID, userId);
        return permissionMapper.selectList(qw);
    }
}
