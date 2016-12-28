package com.lucky.web;

import com.lucky.domain.User;
import com.lucky.service.UserService;
import com.lucky.utils.BaseUtils;
import com.lucky.utils.ChangePasswordRequest;
import com.lucky.utils.JsonView;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lucky on 12/28/16.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public User test() {
        return userService.findOne(1);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String login() {
        return "success";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/info")
    public Map info() {
        Object principal = SecurityUtils.getSubject().getPrincipal();
        Map<String, Object> map = new HashMap();
        map.put("user", principal);
        return map;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pwd")
    public JsonView changePwd(@RequestBody ChangePasswordRequest request) {
        User user = BaseUtils.currentUser();
        if (!user.getPassword().equals(BaseUtils.md5(request.getOldPwd()))) {
            return JsonView.fail("原密码错误！");
        }
        user.setPassword(BaseUtils.md5(request.getNewPwd()));
        userService.update(user);
        return JsonView.success("密码修改成功！");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pwd/verify")
    public JsonView verifyPwd() {
        return JsonView.success();
    }

}
