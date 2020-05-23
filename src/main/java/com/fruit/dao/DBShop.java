package com.fruit.dao;

import com.fruit.Object.ShopObject;

import java.util.List;

public interface DBShop {
    public int AddShopOne(int shopid,String shopname,String shopimg,String shopdetail);
    public int UpdateShopOne(int shopid,String shopname,String shopimg,String shopdetail);
    public int DelOne(int shopid);
    public List<ShopObject> FindShopAll();
    public List<ShopObject> FindShopOne(int id);
    public int FindShopTwo(String shopname);
}
