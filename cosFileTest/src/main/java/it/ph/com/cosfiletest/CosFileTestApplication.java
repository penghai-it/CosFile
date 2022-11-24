package it.ph.com.cosfiletest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("it.ph.com.cosfiletest.mapper")
public class CosFileTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CosFileTestApplication.class, args);
    }

}
