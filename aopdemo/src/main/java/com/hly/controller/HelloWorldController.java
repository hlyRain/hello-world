package com.hly.controller;


import com.hly.model.HelloModel;
import com.hly.service.HelloService;
import com.hly.util.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author linyuhuang
 */
@Api(tags = "Hello World 例子接口", description = "提供Hello相关的Rest API")
@RestController
@RequestMapping("/hello")
public class HelloWorldController {


    @Autowired
    private HelloService helloService;

    /**
     * 这个例子返回简单字符串Hello world
     * @return
     */
    @ApiOperation("返回Hello World！")
    @GetMapping("/index")
    public ResultVO<String> index() {
        return ResultVO.getSuccess("Hello World!");
    }

    /**
     * 返回列表
     * @return
     */
    @ApiOperation("返回表hello所有的内容")
    @GetMapping("/list")
    public ResultVO<List<HelloModel>> list() {
        List<HelloModel> list = helloService.selectAll();
        return ResultVO.getSuccess(list);
    }
}