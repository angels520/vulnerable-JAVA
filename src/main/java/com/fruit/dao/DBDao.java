package com.fruit.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.fruit.Object.AdminObject;
import com.fruit.Object.UserObject;

/**
 * Created by xi on 2015/10/4.
 */
public interface DBDao {
    public  Connection getConnection();
    public void close(ResultSet rs, Statement stat, Connection conn);
    public int LoginCheck(String username,String password);
    //数据操作
    public List<UserObject> FindUserAll();
    public List<AdminObject> FindAdminAll();
    public int FindUserOne(String username);
    public int AddUserOne(int id,String username,String password,String email,int islock);
    public int UpdateUserOne(int id,String username,String password);
    public int DelOne(int id);
    public int DelAdminOne(int id);
    public int DelMany(int[] id);
    public int UpdateAdminOne(int id,String username, String password);
    public int AddAdminOne(int id,String username,String password);
    public int UserLogin(String username,String password);
}
