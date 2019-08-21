package com.zqw.imageupup.bean;

import com.aliyun.oss.model.Owner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Classname ImageDetailVO
 * @Description 图片详细VO
 * @Date 2019/8/21 11:22
 * @Created by zqw
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageDetailVO {

    /**
     * 图片名字
     */
    private String imageName;
    /**
     * 图片地址
     */
    private String imageUrl;

    private String bucketName;

    private String eTag;

    private Long imageSize;

    private LocalDateTime lastModifiedTime;

    private String storageClass;

    private Owner owner;
}
