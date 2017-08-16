package com.example.demo.server.controller;

import com.example.demo.Author;
import com.example.demo.server.dao.UserMapper;
import com.example.demo.shared.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Locale;

/**
 * @Version
 * @Title: GreetingController
 * @Package: package com.example.demo.server.controller
 * @Description:
 * @Author: WenJie
 * @Date: 2017/8/14
 */
@Controller
public class GreetingController {
    @Autowired
    private Author author;
    @Autowired
    private UserMapper userMapper;

    //代码里使用国际化信息
    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/")
    public String index(Model model) {
        Locale locale = LocaleContextHolder.getLocale();
        String greetingPrefix = messageSource.getMessage("welcome",null,locale);
        model.addAttribute("greeting", greetingPrefix + " " + author.getName());
        List<User> users = userMapper.selectAllUsers();
        model.addAttribute("users",users);
        return "index";
    }
}
