package com.blibli.academy.project.service.impl;

import com.blibli.academy.project.Business.dto.*;
import com.blibli.academy.project.Business.pojo.Student;
import com.blibli.academy.project.Business.pojo.User;
import com.blibli.academy.project.Business.pojo.Video;
import com.blibli.academy.project.businsess.Contefor;
import com.blibli.academy.project.businsess.Dto.StudentDto;
import com.blibli.academy.project.codeconst.RessNull;
import com.blibli.academy.project.mapper.StudentDao;
import com.blibli.academy.project.mapper.UserMapper;
import com.blibli.academy.project.service.StudentService;
import com.blibli.academy.project.util.WechatUserUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-20 15:32
 */
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    StudentDao studentDao;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public StuentCardDto selectAll(Long id) throws RessNull {
        User user = userMapper.selectByPrimaryKey(id);
        log.debug("查出用户数据"+user);
        if (user == null){
            throw new RessNull("此用户不存在");
        }
        StuentCardDto stuentCardDto = new StuentCardDto();
        BeanUtils.copyProperties(user,stuentCardDto);
        return stuentCardDto;
    }

    /**
     * 用户绑定
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public StudentBindingDto selectBinding(Long id) throws RessNull {
        User user = userMapper.selectByPrimaryKey(id);
        if (user==null){
            throw new RessNull("提醒用户不存在");
        }
        StudentBindingDto studentBindingDto = new StudentBindingDto();
        BeanUtils.copyProperties(user,studentBindingDto);
        return studentBindingDto;
    }

    /**
     * 编辑学员信息
     * @param studentDto
     * @return
     * @throws RessNull
     */
    @Override
    public String updateStudent(StudentDto studentDto) throws RessNull {
        String media_id = studentDto.getMediaId();
        StuentCardDto stuentCardDto = new StuentCardDto();
        stuentCardDto = Contefor.StudentDtoStudentCaedDto(studentDto);
        String imageUrl = null;
        if (media_id != null){
            try {
                imageUrl= WechatUserUtil.downloadMedia(WeixinAccessToken.getAccessToken(),media_id);
                log.info("token:" + WeixinAccessToken.getAccessToken());
                stuentCardDto.setHeadImgUrl(imageUrl);
                log.info("用户资料编辑上传图片url:"+imageUrl);
            }catch (Exception e){
                log.info("图片上传失败");
                e.printStackTrace();
            }
        }
        log.info("更新得参数:"+ stuentCardDto);
        User user = Contefor.StudentCartDtoToUserDoConvert(stuentCardDto);
        Integer updateStatus = userMapper.updateByPrimaryKeySelective(user);
        if (updateStatus == 0){
            throw new RessNull("提醒用户资料未改变或用户不存在");
        }
        return imageUrl;
    }

    @Override
    public PageInfo findCollectArticle(Long id, Integer pageNum) throws RessNull {
        PageHelper.startPage(pageNum,10);
        List<StudentArticleDto> studentArticleDtos = studentDao.findCollectArticle(id);
        if (studentArticleDtos.isEmpty()){
            throw new RessNull("提醒 未查询到用户收藏的文章");
        }
        log.debug("查询到得页数与id信息:"+id,pageNum);
        PageInfo<StudentArticleDto> bean = new PageInfo<>(studentArticleDtos);
        bean.setList(studentArticleDtos);
        return bean;
    }

    @Override
    public PageInfo<Video> findCollectVideo(Long userId, Integer pageNum) throws RessNull {
        PageHelper.startPage(pageNum,10);
        List<Video> homeVideDtos = studentDao.findCollectVideo(userId);
        log.debug("查询得到的页数与id:" + userId,pageNum);
        PageInfo<Video> bean = new PageInfo<>(homeVideDtos);
        bean.setList(homeVideDtos);
        return bean;
    }

    @Override
    public SigningDto updateEmail(Long id, String code) throws RessNull {
        String email = stringRedisTemplate.opsForValue().get(code);
        SigningDto signingDto = new SigningDto();
        if (email == null || email.equals("")) {
            signingDto.setCode(500L);
            signingDto.setState(false);
            return signingDto;
        }
        // 成功取出后删除缓存
        stringRedisTemplate.delete(code);
        User user3 = new User();
        user3.setId(id);
        User user1 = userMapper.selectOne(user3);
        if (user1.getPhone() != null && !user1.getBinding()) {
            user1.setBinding(true);
            user1.setData(user1.getData() + 20);
            signingDto.setGainBean(20);
            userMapper.updateByPrimaryKeySelective(user1);
        }
        signingDto.setState(true);
        log.info("验证成功后的邮箱：" + email);
        User user = new User();
        user.setEmail(email);
        user.setId(id);
        userMapper.updateByPrimaryKeySelective(user);
        signingDto.setState(true);
        return signingDto;
    }
    @Override
    public SigningDto updatePhone(Long id,String code)throws RessNull {
        String phone = stringRedisTemplate.opsForValue().get(code);
        SigningDto signingDto = new SigningDto();
        if (phone == null || phone.equals("")) {
            signingDto.setCode(500L);
            signingDto.setState(false);
            return signingDto;
        }
        stringRedisTemplate.delete(code);
        User user = new User();
        user.setId(id);
        User user1 = userMapper.selectOne(user);
        if (user1.getEmail() != null && !user1.getBinding()) {
            user1.setBinding(true);
            user1.setData(user1.getData() + 20);
            signingDto.setGainBean(20);
            userMapper.updateByPrimaryKeySelective(user1);
        }
        Long IPhone = Long.parseLong(phone);
        log.debug("验证码号码:" + phone);
        User user2 = new User();
        user2.setPhone(IPhone);
        user2.setId(id);
        userMapper.updateByPrimaryKeySelective(user2);
        signingDto.setState(true);
        return signingDto;
    }

}
