package com.hopu.login.service.impl;


import com.hopu.login.dao.LoginDao;
import com.hopu.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shijie
 * #Description OrderServiceImp
 * #Date: 2022/10/19 21:57
 */
@Service("loginService")
public class LoginServiceImp implements LoginService {
    @Autowired(required=false)
    LoginDao loginDao;

    @Override
    public Map login(Map map) {
        return loginDao.login("LoginMapper.login",map);
    }
    @Override
    public int add(Map map) {
        return loginDao.add("LoginMapper.add",map);
    }
}
