package com.konosuba.oauth2.server.config.service;

import com.konosuba.oauth2.domain.entity.Permission;
import com.konosuba.oauth2.domain.entity.User;
import com.konosuba.oauth2.service.PermissionService;
import com.konosuba.oauth2.service.UserService;
import org.assertj.core.util.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.assertj.core.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 自定义用户认证与授权
 * <p>
 * Description:
 * </p>
 *
 * @author Lusifer
 * @version v1.0.0
 * @date 2020-9-1
 * @see com.konosuba.oauth2.server.config
 */

public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserService userService;

    @Resource
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询信息
        User user = userService.getByUsername(username);
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        if (user != null) {
            // 用户授权
            List<Permission> permissions = permissionService.selectById(user.getId());
            // 声明用户授权
            for (Permission permission : permissions) {
                if (permission != null && permission.getEnname() != null) {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getEnname());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
