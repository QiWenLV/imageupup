package com.zqw.imageupup.api;

import com.zqw.imageupup.bean.ImageDetailVO;
import com.zqw.imageupup.bean.ImageListVO;

import java.awt.*;
import java.util.List;

/**
 * @Classname ImageManagementService
 * @Description 管理图片
 * @Date 2019/8/21 11:20
 * @Created by zqw
 * @Version 1.0
 */
public interface ImageManageService {

    List<ImageListVO> getImageList();

    ImageDetailVO getImageDetail();

}
