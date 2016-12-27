package com.lucky.mapper;

import com.lucky.config.CommonMapper;
import com.lucky.domain.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by lucky on 16-12-27.
 */
@Mapper
public interface CommentMapper extends CommonMapper<Comment>{
    int deleteById(long commentId);
    int insert(Comment record);
    int insertSelective(Comment record);
    Comment selectById(long commentId);
    int updateByIdSelective(Comment record);
    int updateByIdWithBLOB(Comment record);
    int updateById(Comment record);
}
