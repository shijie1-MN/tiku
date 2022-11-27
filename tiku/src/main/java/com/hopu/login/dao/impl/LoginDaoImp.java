package com.hopu.login.dao.impl;


import com.hopu.login.dao.LoginDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author shijie
 * #Description OrderDaoImp
 * #Date: 2022/10/19 21:58
 */
@Repository("loginDao")
public class LoginDaoImp implements LoginDao {
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;

    @Override
    public Map login(String str, Map map) {
        return sqlSessionTemplate.selectOne(str,map);
    }

    @Override
    public int add(String str,Map map) {
        return sqlSessionTemplate.insert(str,map);
    }

}
