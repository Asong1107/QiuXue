//package com.blibli.academy.project;
//
//import com.blibli.academy.project.Business.dto.StudentDto;
//import com.blibli.academy.project.service.StuentService;
//import com.blibli.academy.project.util.RandNumUtil;
//import org.junit.Task;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.controller.context.SpringBootTest;
//import org.springframework.controller.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Blibliadmin.class)
//public class ProjectApplicationTests {
//
//    @Autowired
//    StuentService stuentService;
//    @Task
//    public void instert()throws Exception{
//        StudentDto studentDto = new StudentDto();
//        for (int i = 0;i < 1;i++){
//            studentDto.setContent("正文" + RandNumUtil.getRandLength(20)+"这是正文这是正文这是正文");
//            studentDto.setAuthor(RandNumUtil.getRandRange(1,7));
//            studentDto.setClassify(RandNumUtil.getRandRange(1,2));
//            studentDto.setCollect(Long.valueOf(RandNumUtil.getRandRange(20,1000)));
//            studentDto.setIntroduce("简介简介简介这是简介简"+RandNumUtil.getRandLength(5));
//            studentDto.setImg_url("http://93.179.100.194:8080/cover_plan.jpg");
//            studentDto.setVideo_url("http://93.179.100.194:8080/test_video.mp4");
//            studentDto.setGrade(RandNumUtil.getRandRange(1,6));
//            studentDto.setSubject(RandNumUtil.getRandRange(1,6));
//            studentDto.setTitle("这是标题" + RandNumUtil.getRandLength(5));
//            studentDto.setVideo_time(Long.valueOf(RandNumUtil.getRandRange(200,980)));
//            studentDto.setStudy_type(RandNumUtil.getRandRange(1,2));
//            studentDto.setLove(Long.valueOf(RandNumUtil.getRandRange(30,500)));
//            studentDto.setStatus(RandNumUtil.getRandRange(1,10)>5);
//            System.out.println("studentservuce+insert(studey)"+stuentService.insert(studentDto).toString());
//
//
//        }
//    }
//}
