package com.jiangfendou.springcloud.type;

public enum ErrorCode {

    CREAT_ERROR ("p.bas.0001", "添加失败"),
    NOT_FOUND ("p.bas.0002", "目标数据没有被找到");

    /** error code */
    private final String code;
    /** error message */
    private final String message;

    /**
     * Constructor.
     *
     * @param code code of error code
     */
    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

}
