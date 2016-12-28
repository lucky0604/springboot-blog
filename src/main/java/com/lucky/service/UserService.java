package com.lucky.service;

import com.lucky.domain.User;

/**
 * Created by lucky on 12/28/16.
 */
public interface UserService {
    User findOne(long id);
    User findByUsername(String username);
    int save(User user);
    int update(User user);
}
