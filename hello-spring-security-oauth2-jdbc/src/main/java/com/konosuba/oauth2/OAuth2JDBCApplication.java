package com.konosuba.oauth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 认证服务器，用于获取 Token
 * <p>
 * Description:
 * </p>
 *
 * @author konosuba
 * @version v1.0.0
 * @date 2020.8.29
 * @see com.konosuba.oauth2
 */
@SpringBootApplication
@MapperScan("com.konosuba.oauth2.mapper")
public class OAuth2JDBCApplication {
    public static void main(String[] args) {
        SpringApplication.run(OAuth2JDBCApplication.class, args);
    }
}
