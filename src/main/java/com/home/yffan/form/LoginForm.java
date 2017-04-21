package com.home.yffan.form;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;


/**
 * Created by Yffan on 01.04.2017.
 */

public class LoginForm {

    @NotEmpty
    @Size(min = 1, max = 60)
    private String login;

    @NotEmpty
    @Size(min = 1, max = 60)
    private String password;

    public void setLogin(String login) {
        this.login = login;
    }
    public String getLogin() {
        return login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
}
