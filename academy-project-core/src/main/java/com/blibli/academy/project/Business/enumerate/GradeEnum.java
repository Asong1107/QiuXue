package com.blibli.academy.project.Business.enumerate;

/**
 * 年级枚举
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-07 01:43
 */
public enum  GradeEnum {
    ONE(1, "初一"), TOW(2, "初二"), THREE(3, "初三"),
    FOUR(4, "高一"), FIVE(5, "高二"), SIX(6, "高三"), ALL(0, "全部");

    private int code;
    private String grade;//年级


    GradeEnum(int code, String grade){
        this.code = code;
        this.grade = grade;
    }

    public static GradeEnum getGradEnum(Integer code){
        if (code == null | 0 == code){
            return ALL;
        }
        for (GradeEnum grade : GradeEnum.values()){
            if (grade.getCode() == code){
                return grade;
            }
        }
        return null;
    }

    public static GradeEnum getGradEnum(String enumName){
        if(enumName == null | "".equals(enumName)){
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
