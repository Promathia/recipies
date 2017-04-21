package com.home.yffan.dao.user;

import com.home.yffan.beans.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Yffan on 28.03.2017.
 */

@Repository("userDAO")
public class UserDAOImpl implements IUserDAO {

    private enum UserColumns {
        ID, NAME, SURNAME, AGE
    }

    @Resource(name = "sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    public Integer saveUser(final User user) {
        /*Session session = sessionFactory.openSession();
        String SQL_QUERY = "SELECT * FROM recipes.users WHERE users.login='12' AND users.password='12'";
        Query query = session.createSQLQuery(SQL_QUERY);
        query.setParameter("name", user.getFirstName());
        query.setParameter("surname", user.getLastName());
        query.setParameter("age", user.getAge());
        Integer save = query.executeUpdate();
        session.close();
        return save;*/
        return 1;
    }

    @Override
    public Boolean checkUser(String login, String password) {
        final int LOGIN = 0;
        final int PASSWORD = 1;
        Boolean userValid = false;
        Session session = sessionFactory.openSession();
        String SQL_QUERY = "SELECT * FROM recipes.users WHERE users.login=? AND users.password=?";
        Query query = session.createSQLQuery(SQL_QUERY);
        query.setParameter(LOGIN, login);
        query.setParameter(PASSWORD, password);
        List list = query.list();
        if ((list != null) && (list.size() > 0)) {
            userValid= true;
        }
        session.close();
        return userValid;
    }

}
