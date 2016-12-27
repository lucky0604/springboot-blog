package com.lucky.mapper;

import com.lucky.config.CommonMapper;
import com.lucky.domain.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lucky on 16-12-28.
 */
@Mapper
public interface ArticleMapper extends CommonMapper<Article>{
    int insert(Article record);
    int insertSelective(Article record);
    int deleteById(long articleId);
    int updateByIdSelective(Article record);
    int updateByIdWithBLOBs(Article record);
    int updateById(Article record);
    Article selectById(long id);
    List<Article> selectAllByDeleted(boolean deleted);
    List<Article> selectAllByCategoryAndDeleted(@Param(value = "categoryId") long categoryId, @Param(value = "deleted") boolean deleted);
}
