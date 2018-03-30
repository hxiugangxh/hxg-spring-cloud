package com.hxg.simpledemo.aspect.exception;

import com.hxg.simpledemo.aspect.result.MyFieldError;
import com.hxg.simpledemo.aspect.result.RestResult;
import com.hxg.simpledemo.aspect.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Collection;


@ControllerAdvice
@Slf4j
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public RestResult handle(Exception e) {
        if (e instanceof UserException) {
            UserException userException = (UserException) e;

            return ResultUtil.fail(userException.getMessage());
        } else {
            log.info("[系统异常]{}", e);
            return ResultUtil.fail("服务器内部错误,请联系管理员");
        }
    }

    /**
     * 处理服务地址正确，但是http请求方法错误的情况
     **/
    @ResponseBody
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public RestResult handleNotFoundException(Exception ex) {
        ex.printStackTrace();
        return ResultUtil.fail(ex.getMessage());
    }

    /**
     * 请求参数错误
     **/
    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    // @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    public RestResult IllegalArgumentException(Exception ex) {
        ex.printStackTrace();
        return ResultUtil.fail(ex.getMessage());
    }


    /**
     * 1.HttpMessageNotReadableException：处理post 请求时参数类型错误
     * 2.MethodArgumentTypeMismatchException：处理get 请求时参数类型错误
     **/
    @ResponseBody
    @ExceptionHandler({HttpMessageNotReadableException.class, MethodArgumentTypeMismatchException
            .class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public RestResult parameterTypeErrorException(Exception e) {
        e.printStackTrace();
        return ResultUtil.fail("参数类型错误");
    }

    /**
     * GET请求时，缺少必须参数（参数形式为？号后面的一串，缺少路径上的参数时，匹配到404）
     **/
    @ResponseBody
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public RestResult missingParameterException(MissingServletRequestParameterException e) {
        e.printStackTrace();
        return ResultUtil.fail(e.getMessage());
    }

    /**
     * 字段校验错误统一捕获处理
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public RestResult validateErrorHandler(MethodArgumentNotValidException e) {
        e.printStackTrace();
        BindingResult bindingResult = e.getBindingResult();
        if (bindingResult.hasErrors()) {
            Collection<MyFieldError> collect = CollectionUtils.collect(bindingResult
                    .getFieldErrors(), new Transformer<FieldError, MyFieldError>() {

                public MyFieldError transform(FieldError o) {
                    MyFieldError fieldError = new MyFieldError();
                    fieldError.setField(o.getField());
                    fieldError.setMsg(o.getDefaultMessage());
                    return fieldError;
                }
            });
            return ResultUtil.fail("字段校验失败", collect);
        } else {
            return ResultUtil.fail("字段校验失败");
        }
    }

 }
