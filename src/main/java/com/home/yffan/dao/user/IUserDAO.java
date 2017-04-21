package com.home.yffan.dao.user;

import com.home.yffan.beans.User;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Yffan on 28.03.2017.
 */

public interface IUserDAO {

    public Integer saveUser(User user);

    public Boolean checkUser(String login, String password);

}

