package com.hxg.demo.base.exception;

import com.hxg.demo.base.result.ResultEnum;

public class UserException extends RuntimeException {
    private Integer code;

    public UserException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();

        this.printStackTrace();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
