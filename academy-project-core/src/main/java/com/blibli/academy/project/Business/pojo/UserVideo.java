package com.blibli.academy.project.Business.pojo;

import lombok.Data;
import java.util.Date;

/**
 * @author baich
 * 用户视频实体类
 */
@Data

public class UserVideo {
    private Long id;
    private Long userId;
    private Long videoId;
    private Long collectionCode;
    private Long loveCode;
    private Date collectionAt;
    private Date loverAt;

    //判断是点赞还是收藏
    private Long type;

}
