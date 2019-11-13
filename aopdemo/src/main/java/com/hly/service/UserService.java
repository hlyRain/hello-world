package com.hly.service;


import com.github.pagehelper.PageHelper;
import com.hly.mapper.UserMapper;
import com.hly.model.User;
import com.hly.util.PageTableRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> selectAll(PageTableRequest request) {
        PageHelper.startPage(request.getLimit(), request.getOffset());
        return userMapper.selectAll();
    }

    public boolean updateValue(User model) {
        return userMapper.updateByPrimaryKeySelective(model) > 0;
    }

    public boolean deleteByPrimaryKey(Integer id){
        return userMapper.deleteByPrimaryKey(id) > 0;
    }

    public boolean insert(User record){
        return userMapper.insert(record) > 0;
    }

    public boolean insertSelective(User record){
        return userMapper.insertSelective(record) > 0;
    }

    public User selectByPrimaryKey(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(User record){
        return userMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(User record){
        return userMapper.updateByPrimaryKey(record);
    }


}

