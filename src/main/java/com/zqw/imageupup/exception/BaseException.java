package com.zqw.imageupup.exception;

/**
 * @Classname BaseException
 * @Description 异常基础类型
 * @Date 2019/8/21 10:48
 * @Created by zqw
 * @Version 1.0
 */
public class BaseException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public BaseException(Exception e) {
        super(e.getMessage(), e);
    }

    public BaseException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BaseException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BaseException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BaseException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
