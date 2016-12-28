package com.lucky.service;

import com.github.pagehelper.PageInfo;
import com.lucky.domain.Category;
import com.lucky.utils.PageRequest;

import java.util.List;

/**
 * Created by lucky on 12/28/16.
 */
public interface CategoryService {
    Category findById(long id);
    PageInfo findAll(PageRequest pageRequest);
    List<Category> findAll();
    int save(Category category);
    int delete(long id);
    int update(Category category);
    Category getOne(long id);
}
