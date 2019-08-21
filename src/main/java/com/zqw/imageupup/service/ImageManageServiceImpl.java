package com.zqw.imageupup.service;

import com.zqw.imageupup.api.ImageManageService;
import com.zqw.imageupup.bean.ImageDetailVO;
import com.zqw.imageupup.bean.ImageListVO;
import com.zqw.imageupup.bean.OSSBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname ImageManageServiceImpl
 * @Description 图片管理实现类
 * @Date 2019/8/21 11:23
 * @Created by zqw
 * @Version 1.0
 */
@Service
public class ImageManageServiceImpl implements ImageManageService {

    private final OSSBean ossBean;

    public ImageManageServiceImpl(OSSBean ossBean) {
        this.ossBean = ossBean;
    }

    @Override
    public List<ImageListVO> getImageList() {
        

        return null;
    }

    @Override
    public ImageDetailVO getImageDetail() {
        return null;
    }
}
