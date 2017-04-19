package com.loman.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.loman.bean.User;
import com.loman.dao.IBaseDao;
import com.loman.dao.impl.BaseDaoImpl;
import com.loman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/19.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BaseDaoImpl baseDao;

    public User selectUserById(Integer userId) {
        return (User) baseDao.findForObject("userMapper.selectUserById",userId);
    }

    public PageInfo<User> queryByPage(String userName, Integer pageNo, Integer pageSize) {
        int pageNoInt = pageNo == null?1:pageNo;
        int pageSizeInt = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNoInt,pageSizeInt);
        List<User> list = (List<User>) baseDao.findForList("userMapper.selectUserByUserName",userName);
        PageInfo<User> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }
}
