package it.ph.com.controller;

import it.ph.com.service.Testsss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author PH
 * @时间： 2022/6/30
 * @描述：
 */
@RestController
@RequestMapping("/api")
public class TestController {
    @Autowired
    Testsss testsss;

    @RequestMapping("/test")
    public void tsss() {
        testsss.test();
    }
}
