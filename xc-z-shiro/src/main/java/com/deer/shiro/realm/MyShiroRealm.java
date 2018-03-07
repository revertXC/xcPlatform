package com.deer.shiro.realm;

import com.deer.model.Permission;
import com.deer.model.Role;
import com.deer.model.User;
import com.deer.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 自定义权限匹配和账号密码匹配
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 授权：
     *  未加入缓存：用户需要权限的时候 进行授权
     *  加入缓存：第一次授权完了之后 进行缓存
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("加入Ehcache缓存");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        for(Role role : user.getListRole()){
            authorizationInfo.addRole(role.getName());
            for(Permission permission : role.getListPermission()){
                authorizationInfo.addStringPermission(permission.getPermissionStr());
            }
        }
        return authorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        User user = new User();
        String account = (String)authenticationToken.getPrincipal();
        user.setAccount(account);
        List<User> listUser = userService.selectByEntity(user);
        if(listUser.size() < 0){
            return null;
        }

        user = listUser.get(0);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, //用户名
                user.getPassword(), //密码
                //ByteSource.Util.bytes("123"),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }
}
