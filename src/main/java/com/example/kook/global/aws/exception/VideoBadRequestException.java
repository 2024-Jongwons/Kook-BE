package com.example.kook.global.aws.exception;

import com.example.kook.global.error.exception.BaseException;
import com.example.kook.global.error.exception.ErrorCode;

public class VideoBadRequestException extends BaseException {
    public static final BaseException EXCEPTION = new VideoBadRequestException();
    private VideoBadRequestException(){
        super(ErrorCode.VIDEO_BAD_REQUEST);
    }
}

