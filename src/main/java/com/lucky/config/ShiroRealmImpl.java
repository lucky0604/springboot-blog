package com.lucky.config;

import com.lucky.domain.User;
import com.lucky.service.UserService;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lucky on 16-12-28.
 */
public class ShiroRealmImpl extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    // 用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("doGetAuthorizationInfo(PrincipalCollection principals)");
        principals.getRealmNames();
        return null;
    }

    // 用于认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        User user = userService.findByUsername(username);

        if (user == null) {
            throw new UnknownAccountException();  //没找到帐号
        }
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        return new SimpleAuthenticationInfo(
                user,
                user.getPassword(), //密码
//        ByteSource.Util.bytes(user.getSalt()),//salt  加密使用的盐
                getName()  //realm name
        );
    }
}
