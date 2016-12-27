package com.lucky.mapper;

import com.lucky.config.CommonMapper;
import com.lucky.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by lucky on 16-12-27.
 */
@Mapper
public interface UserMapper extends CommonMapper<User> {
    int deleteById(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectById(Integer userId);

    int updateByIdSelective(User record);

    int updateById(User record);

    User findUserAndRole(long id);

    User findByUsername(String username);
}
