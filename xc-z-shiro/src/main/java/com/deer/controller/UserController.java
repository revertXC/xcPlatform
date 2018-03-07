package com.deer.controller;

import com.deer.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("v1/login")
public class UserController {


    @RequestMapping("go")
    @ResponseBody
    public Object login(User user){
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(user.getAccount());
        token.setPassword(user.getPassword().toCharArray());
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
//            subject.logout();
            User sysUserSaved = (User)subject.getPrincipal();
            System.out.println("登录"+sysUserSaved.getName());
            return sysUserSaved;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }


    @RequiresPermissions("aa:create")
    @RequestMapping("aaaa")
    @ResponseBody
    public String aaa(){
        return "aaa";
    }

    @RequiresPermissions("test:create")
    @RequestMapping("bbbb")
    @ResponseBody
    public String bbb(){
        return "bbb";
    }

}
