package com.lucky.mapper;

import com.lucky.config.CommonMapper;
import com.lucky.domain.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by lucky on 16-12-27.
 */
@Mapper
public interface CategoryMapper extends CommonMapper<Category> {
    int insert(Category record);
    int insertSelective(Category record);
    int deleteById(long categoryId);
    int updateByIdSelective(Category record);
    int updateById(Category record);
    Category selectById(long categoryId);
    List<Category> selectAll();
}
