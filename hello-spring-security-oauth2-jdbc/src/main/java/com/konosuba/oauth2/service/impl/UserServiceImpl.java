package com.konosuba.oauth2.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.konosuba.oauth2.domain.entity.User;
import com.konosuba.oauth2.mapper.UserMapper;
import com.konosuba.oauth2.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getByUsername(String username) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq(User.COL_USERNAME, username);
        return userMapper.selectOne(qw);
    }
}
