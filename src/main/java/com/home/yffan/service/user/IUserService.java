package com.home.yffan.service.user;

import com.home.yffan.beans.User;

/**
 * Created by Yffan on 01.04.2017.
 */
public interface IUserService {

    public Integer saveUser(User user);

    public Boolean checkUser(String login, String password);

}
