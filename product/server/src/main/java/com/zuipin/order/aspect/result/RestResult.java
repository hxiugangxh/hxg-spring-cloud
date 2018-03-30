package com.zuipin.order.aspect.result;

import lombok.Data;

@Data
public class RestResult<T> {
    public static final Integer CODE_OK = 0;
    public static final Integer CODE_FAIL = 1;

    public static <T> RestResult<T> newInstance() {
        return new RestResult<T>();
    }

    private Integer code;
    private String msg;
    private T data;
}
