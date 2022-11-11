package it.ph.com.controller;

import it.ph.com.service.CosFileTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("cosFileTest")
public class CosFileTestController {
    @Autowired
    CosFileTestService cosFileTestService;

    @PostMapping("/upload")
    public String cosFileTest(@RequestBody MultipartFile file) {
        return cosFileTestService.cosFileTest(file);
    }

}
