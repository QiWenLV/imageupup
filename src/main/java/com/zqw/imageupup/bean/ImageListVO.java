package com.zqw.imageupup.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Classname ImageBean
 * @Description 图片列表VO
 * @Date 2019/8/21 11:21
 * @Created by zqw
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageListVO {

    private String nextMarker;
    private String marker;
    private Integer maxKeys;
    private List<ImageDetailVO> imageDetailVOs;
}
