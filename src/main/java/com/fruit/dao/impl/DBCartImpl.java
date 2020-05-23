package com.fruit.dao.impl;

import com.fruit.Object.CartObject;
import com.fruit.dao.DBCart;
import com.fruit.dao.DBDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBCartImpl implements DBCart {
    @Override
    public int AddCartOne(int id, String cartname, long cartprice,String username) {
        Connection conn = null;
        PreparedStatement ps = null;
        DBDao db=new DBDaoImpl();
        String shopimg=FindCartOne(cartname);
        String sql = "insert into cart(id,cartname,cartprice,username,shopimg)values(?,?,?,?,?)";
        int num=0;
        try{
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setString(2,cartname);
            ps.setFloat(3,cartprice);
            ps.setString(4,username);
            ps.setString(5,shopimg);
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
    public int DelOne(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        DBDao db=new DBDaoImpl();
        String sql = "DELETE FROM cart WHERE id="+id;
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
    public List<CartObject> FindCartAll(String username) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        CartObject cart=null;
        List<CartObject> carts = new ArrayList<CartObject>();
        DBDao db=new DBDaoImpl();
        String sql = "select id,cartname,cartprice,shopimg from cart where username="+"'"+username+"';";
        try{
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                cart =new CartObject();
                cart.setId(rs.getInt("id"));
                cart.setCartname(rs.getString("cartname"));
                cart.setCartprice(rs.getFloat("cartprice"));
                cart.setShopimg(rs.getString("shopimg"));
                carts.add(cart);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            db.close(rs, ps, conn);
        }
        return carts;
    }

    @Override
    public String FindCartOne(String shopname) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DBDao db=new DBDaoImpl();
        String result=null;
        String sql = "select shopimg from shangpin where shopname="+"'"+shopname+"';";
        try{
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                result=rs.getString("shopimg");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            db.close(rs, ps, conn);
        }
        return result;
    }
}
