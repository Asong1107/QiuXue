package com.blibli.academy.project.businsess;

import com.blibli.academy.project.Business.dto.HomeArticleDto;
import com.blibli.academy.project.Business.dto.StuentCardDto;
import com.blibli.academy.project.Business.dto.UserDto;
import com.blibli.academy.project.Business.pojo.Student;
import com.blibli.academy.project.Business.pojo.User;
import com.blibli.academy.project.businsess.Dto.StudentDto;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-22 14:37
 */
public class Contefor {


    public static StuentCardDto StudentDtoStudentCaedDto(StudentDto studentDto) {
        StuentCardDto stuentCardDto = new StuentCardDto();
        BeanUtils.copyProperties(studentDto,stuentCardDto);
        return stuentCardDto;

    }

    public static User StudentCartDtoToUserDoConvert(StuentCardDto stuentCardDto) {
        User user = new User();
        BeanUtils.copyProperties(stuentCardDto,user);
        return user;
    }
}
