package com.utsoft.spring.dao;

import org.springframework.stereotype.Component;

/**
 * <br />日期：2017/4/4
 * <br />时间：22:11
 * <br />创建人：刘坤
 * <br />描述：
 */
@Component
public class UserDao implements IUserDao {

    @Override
    public void add(String username,String password){
        System.out.println("username：" + username + "，password：" + password);

    }

}
