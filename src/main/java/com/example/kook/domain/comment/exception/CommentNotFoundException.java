package com.example.kook.domain.comment.exception;

import com.example.kook.global.error.exception.BaseException;
import com.example.kook.global.error.exception.ErrorCode;

public class CommentNotFoundException extends BaseException {
    public static final CommentNotFoundException EXCEPTION = new CommentNotFoundException();
    public CommentNotFoundException() {
        super(ErrorCode.COMMENT_NOT_FOUND);
    }
}