package com.zqw.imageupup.upload;

import com.zqw.imageupup.utils.ImgException;
import com.zqw.imageupup.utils.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
}
