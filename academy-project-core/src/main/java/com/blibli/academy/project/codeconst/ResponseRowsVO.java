package com.blibli.academy.project.codeconst;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author lixiaobai
 * 返回集封装调用的构造函数
 */

@Data
@EqualsAndHashCode(callSuper = false)
public class ResponseRowsVO<T> {
    private Integer code;
    private String message;
    private Long total;
    private Integer pagesize;
    private Integer pageNum;
    private List<T> data;

    public ResponseRowsVO(Integer code, String message, Long total,Integer pagesize, Integer pageNum,List<T> data) {
        this.code = code;
        this.message = message;
        this.total = total;
        this.pagesize = pagesize;
        this.pageNum = pageNum;
        this.data = data;
    }

    public ResponseRowsVO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseRowsVO(Integer code,String message,List<T> data){
        this.code = code;
        this.message = message;
        this.data=data;
    }

    public ResponseRowsVO(Integer code,String message,Long total,List<T> data){
        this.code = code;
        this.message = message;
        this.total=total;
        this.data=data;
    }



}
