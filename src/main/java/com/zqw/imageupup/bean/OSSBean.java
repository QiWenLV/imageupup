package com.zqw.imageupup.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @Classname OSSBean
 * @Description OSS对象
 * @Date 2019/8/21 11:12
 * @Created by zqw
 * @Version 1.0
 */
@Data
@Builder
public class OSSBean {
    private String endpoint;
    // accessKey
    private String accessKeyId;
    private String accessKeySecret;
    //空间
    private String bucketName;

    private OSSBean(){
        endpoint = "oss-cn-shanghai.aliyuncs.com";
        accessKeyId = "LTAIjVwQrtNqJJVj";
        accessKeySecret = "TNfBeTBDQj52rHunemkEJA6g4AQ82P";
        bucketName = "wendy-image";
    }
}
