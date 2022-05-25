package com.example.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND(2001,"你找的问题不在了，要不要换个试试？"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何问题或评论进行回复"),
    NO_LOGIN(2003, "未登录不能进行评论，请先登录"),
    SYS_ERROR(2004, "服务冒烟了，要不你稍后再试试！！！"),
    TYPE_PARAM_WRONG(2005, "评论类型错误或不存在"),
    COMMENT_NOT_FOUNT(2006, "你找的评论不存在了，要不要换个试试？"),
    CONTENT_IS_EMPTY(2007, "评论内容不能为空"),
    INVALID_INPUT(2011, "非法输入");

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    private final Integer code;
    private final String message;

    CustomizeErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
