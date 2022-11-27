package com.hopu.controller;

import com.alibaba.fastjson.JSON;
import com.hopu.util.HttpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shijie
 * #Description LoginController
 * #Date: 2022/10/19 19:13
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    @ResponseBody
    public String querya(@RequestParam Map map){
        String code=map.get("code")+"";
        String str=this.get(code);
        Map map1=new HashMap();
        map1.put(JSON.parseObject(str).get("session_key")+"",JSON.parseObject(str).get("openid")+"");
        return str;
    }
    public String get(String code){
        String APPID="wxa8dce07e22e2a738";
        String SECRET="a9c2911fb0be484b513ecd1a357a7b28";
        String url="https://api.weixin.qq.com/sns/jscode2session?appid="+APPID+"&secret="+SECRET+"&js_code="+code+"&grant_type=authorization_code";
        return HttpUtil.getURL(url);
    }
}
