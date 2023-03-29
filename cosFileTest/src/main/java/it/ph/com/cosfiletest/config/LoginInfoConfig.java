package it.ph.com.cosfiletest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: P H
 * @时间: 2023/3/27
 * @描述:
 */
@Component
public class LoginInfoConfig {
    @Value("${spring.datasource.dynamic.datasource.master.username}")
    public String USERNAME;
    @Value("${spring.datasource.dynamic.datasource.master.password}")
    public String PASSWORD;
    @Value("${config.hostAndPort}")
    public String HOSTANDPORT;
}
