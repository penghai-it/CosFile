package it.ph.com.cosfiletest.service;

import org.springframework.web.multipart.MultipartFile;

public interface CosFileTestService {
    String cosFileTest(MultipartFile file);

    void fileDownload();
}
