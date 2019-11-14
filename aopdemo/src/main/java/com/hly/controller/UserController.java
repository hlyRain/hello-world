package com.hly.controller;


import com.github.pagehelper.PageInfo;
import com.hly.model.User;
import com.hly.service.UserService;
import com.hly.util.PageTableRequest;
import com.hly.util.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author linyuhuang
 */
@Api(tags = "User表增删改查", description = "提供User相关的Rest API")
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;


    @ApiOperation("返回User对象")
    @GetMapping("/helloworld")
    public String  helloworld(){
        return "Hello World";
    }

    /**
     * 这个例子返回一个用户对象
     * @return
     */
    @ApiOperation("返回User对象")
    @GetMapping("/findById")
    public ResultVO<User> selectByPrimaryKey(Integer id){
        User user = userService.selectByPrimaryKey(id);
        if(user==null){
            return ResultVO.getSuccess("没有找到符合条件的数据",null);
        }
        return ResultVO.getSuccess(user);
    }

    /**
     * 返回列表
     * @return
     */
    @ApiOperation("返回表user所有的内容")
    @GetMapping("/list")
    public ResultVO selectAll(PageTableRequest request) {
        List<User> list = userService.selectAll(request);
        if(list.size()==0){
            return ResultVO.getSuccess("没有找到符合条件的数据",null);
        }
        PageInfo pageInfo = new PageInfo(list);

        return ResultVO.getSuccess(pageInfo);
    }


    /**
     * 根据主键删除用户
     * @return
     */
    @DeleteMapping("/deleteById")
    public ResultVO deleteByPrimaryKey(Integer id){
        userService.deleteByPrimaryKey(id);
        return ResultVO.getUpdateSuccess();
    }


    /**
     * 增加用户
     * @return
     */
    @PostMapping("/insert")
    public ResultVO insert(User record){
        userService.insert(record);
        return ResultVO.getUpdateSuccess();
    }



    /**
     * 增加用户(数据不完整)
     * @return
     */
    @PostMapping("/insertSelective")
    public ResultVO insertSelective(User record){
        userService.insertSelective(record);
        return ResultVO.getUpdateSuccess();
    }


    /**
     * 修改用户部分信息
     * @return
     */
    @PutMapping("/updateSelective")
    public ResultVO updateByPrimaryKeySelective(User record){
        userService.updateByPrimaryKeySelective(record);
        return ResultVO.getUpdateSuccess();
    }


    /**
     * 修改用户全部信息
     * @return
     */
    @PutMapping("/updateById")
    public ResultVO updateByPrimaryKey(User record){
        userService.updateByPrimaryKey(record);
        return ResultVO.getUpdateSuccess();
    }


}