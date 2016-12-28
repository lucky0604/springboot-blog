package com.lucky.service;

import com.github.pagehelper.PageInfo;
import com.lucky.domain.Article;
import com.lucky.utils.PageRequest;

import java.util.List;

/**
 * Created by lucky on 12/28/16.
 */
public interface ArticleService {
    Article findById(long id);
    PageInfo findAll(PageRequest pageRequest);
    int save(Article article);
    int updateToDeleted(long id);
    int update(Article article);
    List<Article> findAllByCategoryId(long categoryId);
}
