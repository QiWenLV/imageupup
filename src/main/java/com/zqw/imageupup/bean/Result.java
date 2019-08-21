package com.zqw.imageupup.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname Result
 * @Description 通用返回结果
 * @Date 2019/8/21 10:56
 * @Created by zqw
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result {
    private String code;
    private String message;
}
