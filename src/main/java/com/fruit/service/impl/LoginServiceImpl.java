package com.fruit.service.impl;

import com.fruit.service.LoginService;
import com.fruit.dao.DBDao;
import com.fruit.dao.impl.DBDaoImpl;

public class LoginServiceImpl implements LoginService {
    @Override
    public int Login(String username, String password) {
        DBDao db=new DBDaoImpl();
        int result=db.LoginCheck(username,password);
        return result;
    }
}
