package com.blibli.academy.project.service;

import com.blibli.academy.project.dto.ArticleAuthorDto;
import com.blibli.academy.project.mapper.BaseService;

/**
 * @author lixiaobai
 * @program: project
 * @create: 2018-08-18 21:51
 */
public interface ConsService extends BaseService<ArticleAuthorDto,Long> {

    /**
     * @description 通过作者名称返回作者id
     * @param: [name] 作者名称
     * @return 返回作者id
     */
    Long findAuthorByName(String name) throws Exception;

}
