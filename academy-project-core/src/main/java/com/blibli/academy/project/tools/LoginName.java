package com.blibli.academy.project.tools;

import com.blibli.academy.project.Business.pojo.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author baich
 * 获取当前登陆的用户名称 和 当前时间转换 的封装
 */

@Component
public class LoginName {
    /**
     * 获取当前登陆的用户名
     */
    public  String loginName(){
        System.out.println("进入方法----- loginName");
        Subject subject = SecurityUtils.getSubject();
        UserService user = (UserService) subject.getPrincipal();
        String username = user.getUsername();
        System.out.println("当前登录名为----------"+ username);
        return  username;
    }

    /**
     * 获取当前的时间
     */
    public Date newDate() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String newtime = df.format(date);
        return df.parse(newtime);
    }

    public int newDateSign() {
        System.out.println("进入方法-----  newDateSign");
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        System.out.println(df.format(date));
        return Integer.valueOf(df.format(date));


    }
    public int newDateSignDay() {
        System.out.println("进入方法-----  newDateSignDay");
        SimpleDateFormat df = new SimpleDateFormat("dd");
        Date date = new Date();
        System.out.println("时间转换-----"+ Integer.valueOf(df.format(date)));
        return Integer.valueOf(df.format(date));

    }

}
