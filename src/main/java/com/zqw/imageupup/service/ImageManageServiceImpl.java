package com.zqw.imageupup.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.zqw.imageupup.api.ImageManageService;
import com.zqw.imageupup.bean.ImageDetailVO;
import com.zqw.imageupup.bean.ImageListVO;
import com.zqw.imageupup.bean.OSSBean;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

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
    public ImageListVO getImageList(ImageListVO imageListVO) {
        OSS ossClient = ossBean.getOssClient();
        //查询图片列表，设置起始位置和查询范围大小
        ObjectListing objectListing = ossClient.listObjects(
                new ListObjectsRequest(ossBean.getBucketName())
                        .withMarker(imageListVO.getNextMarker())
                        .withMaxKeys(imageListVO.getMaxKeys())
        );
        //转换，赋值
        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
        List<ImageDetailVO> imageDetailVOs = sums.stream()
                .map(x -> {
                    ImageDetailVO imageDetailVO = ImageDetailVO.builder()
                            .imageName(x.getKey())
                            .imageUrl(x.getKey())
                            .imageSize(x.getSize())
                            .lastModifiedTime(x.getLastModified().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime())
                            .build();
                    BeanUtils.copyProperties(x, imageDetailVO);
                    return imageDetailVO;
                })
                .collect(Collectors.toList());
        imageListVO.setImageDetailVOs(imageDetailVOs);
        //赋值 当前位置，next位置，大小
        BeanUtils.copyProperties(objectListing, imageListVO);
        ossClient.shutdown();
        return imageListVO;
    }

    @Override
    public ImageDetailVO getImageDetail() {
        return null;
    }
}
