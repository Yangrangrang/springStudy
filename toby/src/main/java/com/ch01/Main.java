package toby.src.main.java.com.ch01;

import com.ch01.dao.UserDao;
import com.ch01.domain.User;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDao userDao = new UserDao();

        User user = new User();
        user.setId("test1113");
        user.setName("yang");
        user.setPassword("yang");

        userDao.add(user);

        System.out.println(user.getId() + "등록성공");

        User user2 = userDao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + "조회성공");
    }
}
