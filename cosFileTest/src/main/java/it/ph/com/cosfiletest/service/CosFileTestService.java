package it.ph.com.cosfiletest.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author PH
 * @时间: 2022/11/22
 * @描述:腾讯云COS测试Service
 **/

public interface CosFileTestService {
    /**
     * @param file 附件对象
     * @return: java.lang.String
     * @创建者: PH
     * @时间: 2022/11/22
     * @描述:腾讯云COS对象存储实现文件上传
     **/
    String cosFileTest(MultipartFile file);

    /**
     * @创建者: PH
     * @时间: 2022/11/22
     * @描述:腾讯云COS对象存储实现文件下载
     **/
    void fileDownload();
}
