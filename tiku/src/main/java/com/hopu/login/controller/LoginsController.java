package com.hopu.login.controller;

import com.alibaba.fastjson.JSON;

import com.hopu.bean.Result;
import com.hopu.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

/**
 * @author shijie
 * #Description OrderController
 * #Date: 2022/10/19 21:55
 */
@Controller
@RequestMapping("/LoginController")
public class LoginsController {

    @Autowired
    LoginService loginService;

    Result result=new Result();
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public String login(@RequestParam Map map){
        System.out.println(map);
        result.setCode("0");
        System.out.println("------------------");
        int i=Integer.valueOf(loginService.login(map).get("count")+"");
        if (i==0){
           int a= loginService.add(map);
           if (a==1){
               result.setMsg("登录成功");
           }else {
               result.setMsg("登录失败");
           }
        }else {
            result.setMsg("登录成功");
        }
        return JSON.toJSONString(result);
    }


}
