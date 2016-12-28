package com.lucky.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lucky.domain.Category;
import com.lucky.mapper.CategoryMapper;
import com.lucky.service.CategoryService;
import com.lucky.utils.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lucky on 12/28/16.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Category findById(long id) {
        return categoryMapper.selectById(id);
    }

    @Override
    public PageInfo findAll(PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<Category> articles = categoryMapper.selectAll();
        return new PageInfo(articles);
    }

    @Override
    public List<Category> findAll() {
        return categoryMapper.selectAll();
    }

    @Override
    public int save(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    public int delete(long id) {
        return categoryMapper.deleteById(id);
    }

    @Override
    public int update(Category category) {
        return categoryMapper.updateByIdSelective(category);
    }

    @Override
    public Category getOne(long id) {
        return categoryMapper.selectById(id);
    }
}
