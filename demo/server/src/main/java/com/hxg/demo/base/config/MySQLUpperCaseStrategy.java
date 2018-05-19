package com.hxg.demo.base.config;

import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

/**
 * mysql的表名及字段名自动小写无效化 实现类
 */
public class MySQLUpperCaseStrategy extends SpringPhysicalNamingStrategy {
    @Override
    protected boolean isCaseInsensitive(JdbcEnvironment jdbcEnvironment) {
        return false;
    }
}
