package it.ph.com.cosfiletest.service.impl;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import it.ph.com.cosfiletest.config.ConstantCosConfig;
import it.ph.com.cosfiletest.service.CosFileTestService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@Service
public class CosFileTestServiceImpl implements CosFileTestService {
    /**
     * 腾讯云COS对象存储测试
     * 注意======> secretId和secretKey已经变了需要使用当前的secretId和secretKey todo
     *
     * @param file 文件对象
     * @return 文件下载地址
     */
    @Override
    public String cosFileTest(MultipartFile file) {
        COSClient cosClient = initCos();
        // BUCKET_NAME
        try {
            String filename = file.getOriginalFilename();
            InputStream inputStream = file.getInputStream();
            assert filename != null : "文件名为空";
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
        String filePath = "Test/File/";
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

    /**
     * @return: void
     * @创建者: PH
     * @时间: 2022/11/14
     * @描述:腾讯云COS文件下载
     **/

    @Override
    public void fileDownload() {
        COSClient cosClient = initCos();
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
        listObjectsRequest.setDelimiter(null);
        listObjectsRequest.setBucketName(ConstantCosConfig.BUCKET_NAME);
        ObjectListing objectListing = cosClient.listObjects(listObjectsRequest);
        List<COSObjectSummary> objectSummaries = objectListing.getObjectSummaries();
        for (COSObjectSummary objectSummary : objectSummaries) {
            GetObjectRequest getObjectRequest = new GetObjectRequest(ConstantCosConfig.BUCKET_NAME, objectSummary.getKey());
            //获取附件信息
            String fileName = objectSummary.getKey().split("/")[objectSummary.getKey().split("/").length - 1];
            //文件路径截取
            String filePath = filePath(objectSummary.getKey());
            //下载文件到本地的路径
            File file = new File("F:\\data" + "/" + filePath);
            //判断文件路径是否存在（存在）
            if (file.isDirectory()) {
                file.mkdirs();
            }
            File downFile = new File(file + "/" + fileName);
            ObjectMetadata object = cosClient.getObject(getObjectRequest, downFile);
            String crc64Ecma = object.getCrc64Ecma();
        }
    }


    public String filePath(String path) {
        StringBuilder filePath = new StringBuilder();
        String[] folderPth = path.split("/");
        for (String folder : folderPth) {
            if (!folder.equals(folderPth[folderPth.length - 1])) {
                filePath.append(folder).append("/");
            }
        }
        return String.valueOf(filePath);
    }
}
