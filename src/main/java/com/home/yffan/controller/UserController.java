package com.home.yffan.controller;

import com.home.yffan.form.LoginForm;
import com.home.yffan.service.user.IUserService;
import com.home.yffan.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

/**
 * Created by Yffan on 01.04.2017.
 */

@Controller
@RequestMapping("loginform.html")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String showForm(Map model) {
        LoginForm loginForm = new LoginForm();
        model.put("loginForm", loginForm);
        return "loginform";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processForm(@Valid LoginForm loginForm, BindingResult result, Map model) {
        if (result.hasErrors()) {
            return "loginform";
        }
        Boolean userValid = userService.checkUser(loginForm.getLogin(), loginForm.getPassword());
        if (userValid) {
            model.put("loginForm", loginForm);
            return "loginsuccess";
        } else {
            result.rejectValue("login", "invaliduser");
            return "loginform";
        }

    }

}
