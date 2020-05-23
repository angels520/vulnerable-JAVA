package com.fruit.dao.impl;

import com.fruit.Object.OrderObject;
import com.fruit.dao.DBDao;
import com.fruit.dao.DBOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBOrderImpl implements DBOrder {
    @Override
    public List<OrderObject> FindOrderAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        OrderObject order=null;
        List<OrderObject> orders = new ArrayList<OrderObject>();
        DBDao db=new DBDaoImpl();
        String sql = "select shopid,username,email,iphone,address from `order`";
        try{
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                order=new OrderObject();
                order.setShopid(rs.getInt("shopid"));
                order.setUsername(rs.getString("username"));
                order.setEmail(rs.getString("email"));
                order.setIphone(rs.getString("iphone"));
                order.setAddress(rs.getString("address"));
                orders.add(order);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            db.close(rs, ps, conn);
        }
        return orders;
    }

    @Override
    public int AddOrderpOne(int shopid, String username, String email, String iphone, String address) {
        Connection conn = null;
        PreparedStatement ps = null;
        DBDao db=new DBDaoImpl();
        String sql = "insert into `order`(shopid,username,email,iphone,address) values(?,?,?,?,?)";
        int num=0;
        try{
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,shopid);
            ps.setString(2,username);
            ps.setString(3,email);
            ps.setString(4, iphone);
            ps.setString(5, address);
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
    public int DelOne(int shopid) {
        Connection conn = null;
        PreparedStatement ps = null;
        DBDao db=new DBDaoImpl();
        String sql = "DELETE FROM `order` WHERE shopid="+shopid;
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
    public int[] FindOrderOne(String username) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        OrderObject order=null;
        int[] result = new int[255];
        int count=0;
        DBDao db=new DBDaoImpl();
        String sql = "select id from `cart` where username="+"'"+username+"'";
        try{
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            System.out.print("进入了");
            rs = ps.executeQuery();
            System.out.print("出错了");
            while(rs.next()){
                result[count++]=rs.getInt("id");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            db.close(rs, ps, conn);
        }
        return result;
    }
}
