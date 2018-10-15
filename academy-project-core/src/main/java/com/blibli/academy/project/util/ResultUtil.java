package com.blibli.academy.project.util;

import com.blibli.academy.project.codeconst.ResponseRowsVO;
import com.blibli.academy.project.codeconst.ResponseVO;
import com.blibli.academy.project.codeconst.Stock;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-10 15:06
 */
public class ResultUtil {

    public static ResponseVO error(int code, String message) {
        return vo(code, message);
    }

    public static ResponseVO error(String message, Object object) {
        return vo(Stock.DEFAULT_ERROR_CODE, message, object);
    }

    public static ResponseVO error(String message) {
        return vo(Stock.DEFAULT_ERROR_CODE, message);
    }

    public static ResponseVO success(String message) {
        return vo(Stock.DEFAULT_SUCCESS_CODE, message);
    }


    public static ResponseVO success(String message, Object data) {
        return vo(Stock.DEFAULT_SUCCESS_CODE, message, data);
    }


    public static ResponseRowsVO success(String message, PageInfo<?> pageInfo) {
        return vo(Stock.DEFAULT_SUCCESS_CODE, message, pageInfo.getTotal(), pageInfo.getPageSize(), pageInfo.getPageNum(), pageInfo.getList());
    }


    public static ResponseRowsVO success(String message, List<?> data) {
        return vo(Stock.DEFAULT_SUCCESS_CODE, message, data);
    }

    public static ResponseRowsVO success(String message, Long total, List<?> data) {
        return vo(Stock.DEFAULT_SUCCESS_CODE, message, total, data);
    }


    public static ResponseRowsVO error(String message, List<?> data) {
        return vo(Stock.DEFAULT_ERROR_CODE, message, data);
    }


    /* 调用外部接口 */
    // 自定以状态码

    private static ResponseVO vo(int code, String message) {
        return new ResponseVO<>(code, message, null);
    }

    // 单条数据
    private static ResponseVO vo(int code, String message, Object data) {
        return new ResponseVO<>(code, message, data);
    }

    // 多条数据
    private static ResponseRowsVO vo(int code, String message, List<?> data) {
        return new ResponseRowsVO<>(code, message, data);
    }

    // 分页
    private static ResponseRowsVO vo(int code, String message, Long total,  Integer pagesize,  Integer pageNum, List<?> data) {
        return new ResponseRowsVO<>(code, message, total,pagesize, pageNum, data);
    }


    private static ResponseRowsVO vo2(Integer code, String message) {
        return new ResponseRowsVO<>(code, message);
    }


    private static ResponseRowsVO vo(Integer code, String message, Long total, List<?> data) {
        return new ResponseRowsVO<>(code, message, total, data);
    }


}

