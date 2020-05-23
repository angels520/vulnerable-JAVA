package com.fruit.dao.impl;

import com.fruit.Object.ShopObject;
import com.fruit.dao.DBShop;
import com.fruit.dao.DBDao;
import com.fruit.dao.impl.DBDaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBShopImpl implements DBShop {
    @Override
    public int AddShopOne(int shopid,String shopname,String shopimg,String shopdetail) {
        Connection conn = null;
        PreparedStatement ps = null;
        DBDao db=new DBDaoImpl();
        String sql = "insert into shangpin(shopid,shopname,shopimg,shopdetail)values(?,?,?,?)";
        int num=0;
        try{
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,shopid);
            ps.setString(2,shopname);
            ps.setString(3,shopimg);
            ps.setString(4, shopdetail);
            num=ps.executeUpdate();
            num=1;
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            db.close(null, ps, conn);
            return num;
        }
    }

    @Override
    public int UpdateShopOne(int shopid,String shopname,String shopimg,String shopdetail) {
        Connection conn = null;
        PreparedStatement ps = null;
        int num=0;
        DBDao db=new DBDaoImpl();
        String sql = "UPDATE shangpin SET shopname=?,shopimg=?,shopdetail=? WHERE shopid=?;";

        try{
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,shopname);
            ps.setString(2, shopimg);
            ps.setString(3,shopdetail);
            ps.setInt(4,shopid);
            ps.executeUpdate();
            num=1;
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            db.close(null, ps, conn);
        }
        return num;
    }

    @Override
    public int DelOne(int shopid) {
        Connection conn = null;
        PreparedStatement ps = null;
        DBDao db=new DBDaoImpl();
        String sql = "DELETE FROM shangpin WHERE shopid="+shopid;
        int num=0;
        try{
            conn =db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            num=1;
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            db.close(null, ps, conn);
            return num;
        }
    }

    @Override
    public List<ShopObject> FindShopAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ShopObject shop=null;
        List<ShopObject> shops = new ArrayList<ShopObject>();
        DBDao db=new DBDaoImpl();
        String sql = "select shopid,shopname,shopimg,shopdetail from shangpin";
        try{
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                shop =new ShopObject();
                shop.setShopid(rs.getInt("shopid"));
                shop.setShopname(rs.getString("shopname"));
                shop.setShopimg(rs.getString("shopimg"));
                shop.setShopdetail(rs.getString("shopdetail"));
                shops.add(shop);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            db.close(rs, ps, conn);
        }
        return shops;
    }

    @Override
    public List<ShopObject> FindShopOne(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ShopObject shop=null;
        List<ShopObject> shops = new ArrayList<ShopObject>();
        DBDao db=new DBDaoImpl();
        String sql = "select shopname,shopimg,shopdetail from shangpin where shopid="+id;
        try{
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                shop =new ShopObject();
                shop.setShopname(rs.getString("shopname"));
                shop.setShopimg(rs.getString("shopimg"));
                shop.setShopdetail(rs.getString("shopdetail"));
                shops.add(shop);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            db.close(rs, ps, conn);
        }
        return shops;
    }

    @Override
    public int FindShopTwo(String shopname) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result=0;
        DBDao db=new DBDaoImpl();
        String sql = "select shopid from shangpin where shopname like "+"'"+shopname+"'";
        try{
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                result=rs.getInt("shopid");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            db.close(rs, ps, conn);
        }
        return result;
    }
}
