package com.zqw.imageupup.exception;

public class ImgException extends BaseException{


    public ImgException(Exception e) {
        super(e);
    }

    public ImgException(String msg) {
        super(msg);
    }

    public ImgException(String msg, Throwable e) {
        super(msg, e);
    }

    public ImgException(String msg, int code) {
        super(msg, code);
    }

    public ImgException(String msg, int code, Throwable e) {
        super(msg, code, e);
    }
}
