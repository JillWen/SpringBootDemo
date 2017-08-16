package com.example.demo.server.dao;

import com.example.demo.shared.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper{
    public int deleteByPrimaryKey(int id);

    public int insert(User record);

    public int insertSelective(User record);

    public User selectByPrimaryKey(int id);

    public int updateByPrimaryKeySelective(User record);

    public int updateByPrimaryKey(User record);

    public List<User> selectAllUsers();

    public void deleteAll();

    public int selectCountByUser(User record);
}