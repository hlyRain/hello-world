package com.hly.config;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hly.util.ResultVO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * SpringAOP  log4j2日志配置文件
 * @author linyuhuang
 */
@Aspect
@Component
public class WebLogAspect {


    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(public * com.hly.controller..*.*(..))")
    public void controllerMethod(){
        System.out.println("AOP controller starts;");
    }

    @Before("controllerMethod()")
    public void logRequestInfo(JoinPoint joinPoint) throws JsonProcessingException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        StringBuffer requestLog = new StringBuffer();
        requestLog.append("请求信息：")
                .append("URL = {" + request.getRequestURI() + "},\t")
                .append("HTTP_METHOD = {" + request.getMethod() + "},\t")
                .append("IP = {" + request.getRemoteAddr() + "},\t")
                .append("CLASS_METHOD = {" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "},\t");

        if(joinPoint.getArgs().length == 0) {
            requestLog.append("ARGS = {} ");
        } else {
            requestLog.append("ARGS = " + new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL)
                    .writeValueAsString(joinPoint.getArgs()[0]) + "");
        }

        logger.info(requestLog.toString());
    }


    /**
     * 返回通知  失败之后不会执行
     * @param resultVO
     * @throws Exception
     */
    @AfterReturning(returning = "resultVO", pointcut = "controllerMethod()")
    public void logResultVOInfo(ResultVO resultVO) throws Exception {
        logger.info("请求结果：" + resultVO.getCode() + "\t" + resultVO.getMsg());
    }

    /**
     * 异常通知
     * @param point
     * @param e
     */
    @AfterThrowing(pointcut = "controllerMethod()",throwing = "e")
    public  void throwLog(JoinPoint point, Throwable e){
        System.out.println("异常信息："+e.getMessage());
    }

}
