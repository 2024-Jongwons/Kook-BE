package com.example.kook.domain.post.exception;

import com.example.kook.global.error.exception.BaseException;
import com.example.kook.global.error.exception.ErrorCode;

public class PostNotFoundException extends BaseException {
    public static final BaseException EXCEPTION = new PostNotFoundException();
    public PostNotFoundException() {
        super(ErrorCode.POST_NOT_FOUND);
    }
}