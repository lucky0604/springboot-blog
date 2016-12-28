package com.lucky.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucky.config.Constants;
import com.lucky.domain.Article;
import com.lucky.mapper.ArticleMapper;
import com.lucky.service.ArticleService;
import com.lucky.utils.BaseUtils;
import com.lucky.utils.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lucky on 12/28/16.
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public Article findById(long id) {
        return articleMapper.selectById(id);
    }

    @Override
    public PageInfo findAll(PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<Article> articles = articleMapper.selectAllByDeleted(false);
        // 用PageInfo对结果进行包装
        return new PageInfo(articles);
    }

    @Override
    public int save(Article article) {
        int length = article.getContent().length() > 200 ? 200 : article.getContent().length();
        article.setSummary(article.getContent().substring(0, length));
        article.setStatus(Constants.ArticleStatus.Publish);
        article.setUser(BaseUtils.currentUser());
        return articleMapper.insert(article);
    }

    @Override
    public int updateToDeleted(long id) {
        Article article = articleMapper.selectById(id);
        article.setDeleted(true);
        return articleMapper.updateById(article);
    }

    @Override
    public int update(Article article) {
        int length = article.getContent().length() > 200 ? 200 : article.getContent().length();
        article.setSummary(article.getContent().substring(0, length));
        return articleMapper.updateByIdSelective(article);
    }

    @Override
    public List<Article> findAllByCategoryId(long categoryId) {
        return articleMapper.selectAllByCategoryAndDeleted(categoryId, false);
    }
}
