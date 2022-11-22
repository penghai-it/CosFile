package it.ph.com.cosfiletest.controller;

import it.ph.com.cosfiletest.service.Testsss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PH
 * @时间： 2022/6/30
 * @描述：MyBatis注解式SQL测试Controller
 */
@RestController
@RequestMapping("/api")
public class TestController {
    @Autowired
    Testsss testsss;

    @GetMapping("/test")
    public void tsss() {
        testsss.test();
    }
}
