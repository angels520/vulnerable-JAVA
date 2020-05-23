package com.fruit.dao.impl;

import com.fruit.Object.UserObject;
import com.fruit.Object.AdminObject;
import com.fruit.dao.DBDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBDaoImpl implements DBDao {
    //数据库连接地址
    public static String URL;
    //用户名
    public static String USERNAME;
    //密码
    public static String PASSWORD;
    //mysql的驱动类
    public static String DRIVER;

    //使用静态块加载驱动程序
    static {
        URL = "jdbc:mysql://127.0.0.1:3306/shop?useUnicode=true&characterEncoding=utf-8";
        USERNAME = "root";
        PASSWORD = "123456";
        DRIVER = "com.mysql.jdbc.Driver";
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取连接失败");
        } finally {
            return conn;
        }
    }

    @Override
    public void close(ResultSet rs, Statement stat, Connection conn) {
        try {
            if (rs != null) rs.close();
            if (stat != null) stat.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int LoginCheck(String username,String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result= 0;
        String sql="SELECT id FROM admin WHERE username=? and password=?";
        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if(rs.next()){
                result=1;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            close(rs, ps, conn);
        }
        return result;
    }

    @Override
    public List<UserObject> FindUserAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserObject user=null;
        List<UserObject> users = new ArrayList<UserObject>();
        String sql = "select id,username,password,email,islock from user";
        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                user = new UserObject();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setIslock(rs.getInt("islock"));
                users.add(user);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            close(rs, ps, conn);
        }
        return users;
    }

    @Override
    public List<AdminObject> FindAdminAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AdminObject admin=null;
        List<AdminObject> admins = new ArrayList<AdminObject>();
        String sql = "select id,username,password from admin";
        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                admin = new AdminObject();
                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
                admins.add(admin);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            close(rs, ps, conn);
        }
        return admins;
    }

    @Override
    public int FindUserOne(String username) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserObject user=null;
        String sql = "select id from user where username="+"'"+username+"'";
        int result=0;
        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            result=rs.getInt("id");
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            close(rs, ps, conn);
            return result;
        }
    }

    @Override
    public int AddUserOne(int id,String username, String password, String email, int islock) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "insert into user(id,username,password,email,islock)values(?,?,?,?,?)";
        int num=0;
        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setString(2,username);
            ps.setString(3,password);
            ps.setString(4, email);
            ps.setInt(5, islock);
            num=ps.executeUpdate();
            num=1;
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            close(null, ps, conn);
            return num;
        }
    }

    @Override
    public int UpdateUserOne(int id,String username, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        int num=0;
        String sql = "UPDATE user SET username=?,password=? WHERE id=?;";

        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2, password);
            ps.setInt(3,id);
            ps.executeUpdate();
            num=1;
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
           close(null, ps, conn);
        }
        return num;
    }

    @Override
    public int UpdateAdminOne(int id,String username, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        int num=0;
        String sql = "UPDATE admin SET username=?,password=? WHERE id=?;";

        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2, password);
            ps.setInt(3,id);
            ps.executeUpdate();
            num=1;
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            close(null, ps, conn);
        }
        return num;
    }

    @Override
    public int AddAdminOne(int id, String username, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "insert into admin(id,username,password)values(?,?,?)";
        int num=0;
        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setString(2,username);
            ps.setString(3,password);
            num=ps.executeUpdate();
            num=1;
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            close(null, ps, conn);
            return num;
        }
    }

    @Override
    public int UserLogin(String username, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result= 0;
        //String sql = "SELECT id FROM user WHERE username=? and password=?";
        String sql="SELECT id FROM user WHERE username='"+username+"'"+" and "+"password='"+password+"'";
        //String sql="SELECT id FROM user WHERE username='nihao' or 1=1;/* and password='4297f44b13955235245b2497399d7a93'";
        System.out.print(sql);
        try{
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            //ps.setString(1,username);
            //ps.setString(2,password);
            rs = ps.executeQuery();
            if(rs.next()){
                result=1;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            close(rs, ps, conn);
        }
        return result;
    }

    @Override
    public int DelOne(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "DELETE FROM user WHERE id="+id;
        int num=0;
        try{
            conn =getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            num=1;
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            close(null, ps, conn);
            return num;
        }
    }

    @Override
    public int DelAdminOne(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "DELETE FROM admin WHERE id="+id;
        int num=0;
        try{
            conn =getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            num=1;
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            close(null, ps, conn);
            return num;
        }
    }

    @Override
    public int DelMany(int[] id) {
        int i=0;
        for(i=0;i<id.length;i++){
            DelOne(i);
        }
        return 0;
    }


}
