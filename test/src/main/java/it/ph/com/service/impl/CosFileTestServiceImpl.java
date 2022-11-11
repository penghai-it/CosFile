package it.ph.com.service.impl;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.model.CannedAccessControlList;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;
import it.ph.com.config.ConstantCosConfig;
import it.ph.com.service.CosFileTestService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

@Service
public class CosFileTestServiceImpl implements CosFileTestService {
    @Override
    public String cosFileTest(MultipartFile file) {
        COSClient cosClient = initCos();
        try {
            String filename = file.getOriginalFilename();
            InputStream inputStream = file.getInputStream();
            String filePath = getFilePath(filename);
            // 上传文件
            cosClient.putObject(new PutObjectRequest(ConstantCosConfig.BUCKET_NAME, filePath, inputStream, null));
            cosClient.setBucketAcl(ConstantCosConfig.BUCKET_NAME, CannedAccessControlList.PublicRead);
            return ConstantCosConfig.URL + "/" + filePath;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cosClient.shutdown();
        }
        return null;
    }

    private String getFilePath(String fileName) {
        String filePath = "logo/";
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        filePath += UUID.randomUUID() + fileType;
        return filePath;
    }


    /**
     * 初始化COSClient
     *
     * @return COSClient对象
     */
    private COSClient initCos() {
        // 1 初始化用户身份信息（secretId, secretKey）
        BasicCOSCredentials credentials = new BasicCOSCredentials(ConstantCosConfig.SECRET_ID, ConstantCosConfig.SECRET_KEY);
        // 2 设置 bucket 的区域, COS 地域的简称请参照
        Region region = new Region(ConstantCosConfig.REGION);
        ClientConfig clientConfig = new ClientConfig(region);
        // 从 5.6.54 版本开始，默认使用了 https
//        clientConfig.setHttpProtocol(HttpProtocol.https);
        // 3 生成 cos 客户端。
        return new COSClient(credentials, clientConfig);
    }


}
