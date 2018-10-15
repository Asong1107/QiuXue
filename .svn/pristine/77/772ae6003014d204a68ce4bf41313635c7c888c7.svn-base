package com.blibli.academy.project.Business.enumerate;

/**
 * 学科枚举
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-07 01:46
 */
public enum  SubjectEnum {
    ONE(1, "语文"), TOW(2, "数学"), THREE(3, "英语"),
    FOUR(4, "物理"), FIVE(5, "化学"), SIX(6, "生物"), ALL(0, "全部");

    private int code;
    private String subject;//学科

    SubjectEnum(Integer code, String subject) {
        this.code = code;
        this.subject = subject;
    }
    public static SubjectEnum getSubjectEnum(Integer code){
        if (code == null | 0 ==code){
            return ALL;
        }
        for (SubjectEnum subject : SubjectEnum.values()){
            if (subject.getCode() == code){
                return subject;
            }
        }
        return null;
    }
    public static SubjectEnum getSubjectEnum(String enumName){
        if (enumName == null | "" .equals(enumName)){
            return ALL;
        }
        if ("one".equals(enumName)){
            return ONE;
        }
        if ("tow".equals(enumName)){
            return TOW;
        }
        if ("three".equals(enumName)){
            return THREE;
        }
        if ("four".equals(enumName)){
            return FOUR;
        }
        if ("five".equals(enumName)){
            return FIVE;
        }
        if ("six".equals(enumName)){
            return SIX;
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
