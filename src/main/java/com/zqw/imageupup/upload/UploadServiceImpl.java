package com.zqw.imageupup.upload;

import com.zqw.imageupup.utils.Base64Util;
import com.zqw.imageupup.utils.HttpUtils;
import com.zqw.imageupup.utils.ImgException;
import com.zqw.imageupup.utils.OSSClientUtil;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private OSSClientUtil ossClient;

    @Override
    public String updateHead(MultipartFile file) throws ImgException {
        if (file == null || file.getSize() <= 0) {
//            throw new ImgException("图片不能为空");
            System.out.println("文件大小"+ file.getSize());
        }
        String imgUrl = ossClient.uploadImg2Oss(file);

//        userDao.updateHead(userId, imgUrl);//只是本地上传使用的
        return imgUrl;
    }

    @Override
    public String imageOrc(MultipartFile file) throws IOException {
        Map result = new HashMap();
        if (file == null || file.getSize() <= 0) {
//            throw new ImgException("图片不能为空");
            System.out.println("文件大小"+ file.getSize());
        }

        String host = "https://ocrapi-ugc.taobao.com";
        String path = "/ocrservice/ugc";
        String method = "POST";
        String appcode = "edd10312e8414d0fa79d5c119a907990";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/json; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();


        File f = null;
        String resutl = null;
        try {
            f = File.createTempFile("tmp", null);
            file.transferTo(f);
            //转化为Base64
            String s = Base64Util.fileToBase64(f);
            //上传识别
            String bodys = "{\"img\":\""+ s +"\",\"url\":\"\",\"prob\":false}";

            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            resutl = EntityUtils.toString(response.getEntity());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //使用完删除
            f.deleteOnExit();
        }

       return resutl;
    }
}
