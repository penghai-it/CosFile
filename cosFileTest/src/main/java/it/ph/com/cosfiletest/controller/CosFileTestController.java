package it.ph.com.cosfiletest.controller;


import it.ph.com.cosfiletest.service.CosFileTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("download")
    public String fileDownload() {
        try {
            cosFileTestService.fileDownload();
        } catch (Exception e) {
            return "下载失败,原因：" + e.getMessage();
        }
        return "下载成功";
    }
}
