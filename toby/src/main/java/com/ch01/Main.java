package toby.src.main.java.com.ch01;

import com.ch01.dao.ConnectionMaker;
import com.ch01.dao.DConnectionMaker;
import com.ch01.dao.DaoFactory;
import com.ch01.dao.UserDao;
import com.ch01.domain.User;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDao dao = new DaoFactory().userDao();

        User user = new User();
        user.setId("test1117");
        user.setName("yang");
        user.setPassword("yang");

        dao.add(user);

        System.out.println(user.getId() + "등록성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + "조회성공");
    }
}
