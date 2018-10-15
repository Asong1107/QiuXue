package com.blibli.academy.project.codeconst;

import com.blibli.academy.project.Business.enumerate.ResponseCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-10 14:13
 * 返回集封装
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class ResponseVO<T> {
    private Integer code;
    private String message;
    private T data;

    public ResponseVO(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseVO(ResponseCodeEnum code, T data) {
        // 通过状态码获取状态信息后调用ResponseVO(Integer code, String message, T data) 构造方法
        this(code.getCode(), code.getMessage(), data);
    }

}
