package com.zqw.imageupup.api;

import com.zqw.imageupup.exception.ImgException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadService {

    String updateHead(MultipartFile file) throws ImgException;

    String imageOrc(MultipartFile file) throws IOException;
}
