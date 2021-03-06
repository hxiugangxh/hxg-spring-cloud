package com.hxg.demo.base.result;

public enum ResultEnum {
    FAIL(-1, "失败"),
    SUCCESS(0, "成功"),
    TEST_EXCEPTION(-2, "测试异常抓取"),
    PRIMARY_SCHOOL(100, "我猜你可能还在上小学"),
    MIDDLE_SCHOOL(101, "你可能在上初中");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
