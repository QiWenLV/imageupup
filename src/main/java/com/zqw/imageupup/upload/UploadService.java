package com.zqw.imageupup.upload;

import com.zqw.imageupup.utils.ImgException;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    String updateHead(MultipartFile file) throws ImgException;
}
