package com.example.kook.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    //Bad Request
    BAD_REQUEST(400, "잘못된 요청입니다."),
    IMAGE_BAD_REQUEST(400, "이미지의 형식이 올바르지 않습니다"),
    IMAGE_UPLOAD_FAIL(400, "이미지가 정상적으로 저장되지 않았습니다"),
    VIDEO_BAD_REQUEST(400, "비디오의 형식이 올바르지 않습니다"),
    VIDEO_UPLOAD_FAIL(400, "비디오가 정상적으로 저장되지 않았습니다"),

    COMMENT_NOT_FOUND(404, "댓글을 찾을 수 없습니다."),
    POST_NOT_FOUND(404, "게시글을 찾을 수 없습니다.");

    private final int statusCode;
    private final String errorMessage;
}

