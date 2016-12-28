package com.lucky.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lucky on 12/28/16.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login() {
        return "/admin/login.html";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String sign(HttpServletRequest request) {
        String errorClassName = (String) request.getAttribute("shiroLoginFailure");
        System.out.println(errorClassName);
        return "redirect:/login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/admin")
    public String admin() {
        return "/admin/main.html";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/forbidden")
    public String forbidden() {
        return "forbidden";
    }
}
