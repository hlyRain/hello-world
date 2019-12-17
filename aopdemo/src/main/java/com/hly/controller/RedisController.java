package com.hly.controller;

import com.hly.model.User;
import com.hly.service.UserService;
import com.hly.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 这是一个Redis读写的实战例子
 * @author linyuhuang
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    private static int ExpireTime = 60;

    @Resource
    private RedisUtil redisUtil;

    @Autowired
    private UserService userService;


    @PostMapping("/set")
    public boolean redisset(String key){
        User user =new User();
        user.setId(1);
        user.setWeight("HIGH");
        user.setUsername(key);
        user.setAge(20);
        return redisUtil.set(key,user,ExpireTime);
    }

    @GetMapping("/get")
    public Object redisget(String key){
        return redisUtil.get(key);
    }

    @PutMapping("/expire")
    public boolean expire(String key){
        return redisUtil.expire(key,ExpireTime);
    }


}
