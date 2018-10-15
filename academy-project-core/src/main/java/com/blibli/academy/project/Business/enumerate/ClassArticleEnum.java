package com.blibli.academy.project.Business.enumerate;

/**
 * 文章类型
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-07 01:26
 */

public enum ClassArticleEnum {
    Ban(1, "banner文章"), Card(2, "card文章"), ALL(0, "全部");

    private Integer code;
    private String name;

    ClassArticleEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }
    //通过code获取

    public static ClassArticleEnum getArticleEnum(Integer code){
        if (code == null | 0 == code){
            return ALL;
        }
        for (ClassArticleEnum classArticleEnum : ClassArticleEnum.values()){
            if (classArticleEnum.getCode() == code){
                return classArticleEnum;
            }
        }
        return null;
    }
    public static ClassArticleEnum getArticleEnum(String name){
        if (name == null | "".equals(name)){
            return ALL;
        }
        if ("ban".equals(name)){
            return Ban;
        }
        if ("card".equals(name)){
            return Card;
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
