package com.fruit.dao;


import com.fruit.Object.OrderObject;

import java.util.List;

public interface DBOrder {
    public List<OrderObject> FindOrderAll();
    public int AddOrderpOne(int shopid,String username,String email,String iphone,String address);
    public int DelOne(int shopid);
    public int[] FindOrderOne(String username);
}
