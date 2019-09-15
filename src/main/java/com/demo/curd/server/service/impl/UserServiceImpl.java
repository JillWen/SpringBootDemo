package com.demo.curd.server.service.impl;

import com.demo.curd.server.dao.UserMapper;
import com.demo.curd.server.service.IUserService;
import com.demo.curd.shared.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Version
 * @Title: UserServiceImpl
 * @Package: package com.example.demo.server.service.impl
 * @Description:
 * @Author: WenJie
 * @Date: 2017/8/15
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveUser(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void deleteUserById(int id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userMapper.selectAllUsers();
    }

    @Override
    public void deleteAllUsers() {
        userMapper.deleteAll();
    }

    @Override
    public boolean isUserExist(User user) {
        return userMapper.selectCountByUser(user)>0;
    }
}
