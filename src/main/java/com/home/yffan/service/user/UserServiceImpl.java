package com.home.yffan.service.user;

import com.home.yffan.beans.User;
import com.home.yffan.dao.user.IUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Yffan on 01.04.2017.
 */

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public Integer saveUser(User user) {
        return userDAO.saveUser(user);
    }

    @Override
    public Boolean checkUser(String login, String password) {
        return userDAO.checkUser(login, password);
    }

}
