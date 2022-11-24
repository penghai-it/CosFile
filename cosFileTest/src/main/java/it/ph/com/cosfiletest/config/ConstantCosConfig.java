package it.ph.com.cosfiletest.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 小海
 * @时间: 2022/11/23
 * @描述:配置文件属性
 **/

@Component
public class ConstantCosConfig implements InitializingBean {


    @Value("${tencent.cos.secretId}")
    public String secretId;

    @Value("${tencent.cos.secretKey}")
    public String secretKey;

    @Value("${tencent.cos.buckerName}")
    public String buckerName;

    @Value("${tencent.cos.region}")
    public String region;

    @Value("${tencent.cos.url}")
    public String url;

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private String redisPort;
    @Value("${spring.redis.password}")
    private String redisPassword;
    public static String SECRET_ID;
    public static String SECRET_KEY;
    public static String BUCKET_NAME;
    public static String REGION;
    public static String URL;

    public static String REDIS_HOST;
    public static String REDIS_PORT;
    public static String REDIS_PASSWORD;

    @Override
    public void afterPropertiesSet() throws Exception {
        SECRET_ID = secretId;
        SECRET_KEY = secretKey;
        BUCKET_NAME = buckerName;
        REGION = region;
        URL = url;
        REDIS_HOST = redisHost;
        REDIS_PORT = redisPort;
        REDIS_PASSWORD = redisPassword;
    }
}
