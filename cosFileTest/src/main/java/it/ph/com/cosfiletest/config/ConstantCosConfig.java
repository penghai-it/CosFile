package it.ph.com.cosfiletest.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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

    public static String SECRET_ID;
    public static String SECRET_KEY;
    public static String BUCKET_NAME;
    public static String REGION;
    public static String URL;


    @Override
    public void afterPropertiesSet() throws Exception {
        SECRET_ID = secretId;
        SECRET_KEY = secretKey;
        BUCKET_NAME = buckerName;
        REGION = region;
        URL = url;
    }
}
