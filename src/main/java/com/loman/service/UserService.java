package com.loman.service;

import com.github.pagehelper.PageInfo;
import com.loman.bean.User;

/**
 * Created by Administrator on 2017/4/19.
 */
public interface UserService {

    User selectUserById(Integer userId);

    PageInfo<User> queryByPage(String userName, Integer pageNo, Integer pageSize);
}
