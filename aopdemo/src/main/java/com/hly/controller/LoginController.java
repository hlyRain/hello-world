package com.hly.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "redirect:/tologin";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }



    @RequestMapping(value = "/tologin",method = RequestMethod.GET)
    public String tologinGet() {
        return "/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginGet() {
        return "login";
    }
    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public String mainGet() {
        return "main";
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginPost(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
//        token.setRememberMe(true);
        try {
            subject.login(token);
            return "redirect:/main";
        }catch (UnknownAccountException e1){
            model.addAttribute("msg","用户名不存在");
            return "/login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码不正确");
            return "/login";
        }catch (AuthorizationException e){
            model.addAttribute("msg","没有权限");
            return "/login";
        }catch (AuthenticationException e) {
            model.addAttribute("msg","用户被锁定！");
            return "/login";
        }
    }

    @RequestMapping(value = "/login-error",method = RequestMethod.GET)
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    /*@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model) {
        return "login";
    }
*/


    @RequestMapping(value = "/users/index", method = RequestMethod.GET)
    public String userIndex(Model model) {
        model.addAttribute("productName","黑马程序员");
        return "user/index";
    }

}
