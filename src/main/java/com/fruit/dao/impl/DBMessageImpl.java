package com.fruit.dao.impl;

import com.fruit.Object.MessageObject;
import com.fruit.dao.DBDao;
import com.fruit.dao.DBMessage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBMessageImpl implements DBMessage {
    @Override
    public int AddMessageOne(int id, String username, String email, String url, String question, String message) {
        Connection conn = null;
        PreparedStatement ps = null;
        DBDao db=new DBDaoImpl();
        String sql = "insert into message(id,username,email,url,question,message)values(?,?,?,?,?,?)";
        int num=0;
        try{
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setString(2,username);
            ps.setString(3,email);
            ps.setString(4, url);
            ps.setString(5,question);
            ps.setString(6, message);
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
    public int UpdateMessageOne(int id, String username, String email, String url, String question, String message) {
        Connection conn = null;
        PreparedStatement ps = null;
        int num=0;
        DBDao db=new DBDaoImpl();
        String sql = "UPDATE message SET username=?,email=?,url=?,question=?,message=? WHERE id=?;";

        try{
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2, email);
            ps.setString(3,url);
            ps.setString(4,question);
            ps.setString(5,message);
            ps.setInt(6,id);
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
    public int DelOne(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        DBDao db=new DBDaoImpl();
        String sql = "DELETE FROM message WHERE id="+id;
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
    public List<MessageObject> FindMessageAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MessageObject message=null;
        List<MessageObject> messages = new ArrayList<MessageObject>();
        DBDao db=new DBDaoImpl();
        String sql = "select id,username,email,url,question,message from message";
        try{
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                message =new MessageObject();
                message.setId(rs.getInt("id"));
                message.setUsername(rs.getString("username"));
                message.setEmail(rs.getString("email"));
                message.setUrl(rs.getString("url"));
                message.setQuestion(rs.getString("question"));
                message.setMessage(rs.getString("message"));
                messages.add(message);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            db.close(rs, ps, conn);
        }
        return messages;
    }
}
