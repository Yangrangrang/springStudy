package com.ch01.dao;

import com.ch01.domain.User;

import java.sql.*;

public class UserDao {
    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = getConnection();

        // SQL 담기 (prepareStatement) : users 테이블 insert문
        PreparedStatement ps = c.prepareStatement("insert into users(id,name,password) values (?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        // select문을 제외한 다른 구문을 수행할 때 사용하는 함수 (executeUpdate)
        ps.executeUpdate();

        // SOL prepareStatement 닫기
        ps.close();
        // Connection 닫기
        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection c = getConnection();

        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SPRINGSTUDYDB", "root", "root");
        return c;
    }
}
