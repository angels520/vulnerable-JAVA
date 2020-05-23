package com.fruit.dao;

import com.fruit.Object.CartObject;

import java.util.List;

public interface DBCart {
    public int AddCartOne(int id,String cartname,long cartprice,String username);
    public int DelOne(int id);
    public List<CartObject> FindCartAll(String username);
    public String FindCartOne(String shopname);
}
