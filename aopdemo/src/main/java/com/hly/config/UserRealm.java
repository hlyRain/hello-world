package com.hly.config;

import com.hly.model.User;
import com.hly.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义realm
 */

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行认证逻辑");

        //1. 获取登录用户信息
        User user = (User) principals.getPrimaryPrincipal();
        //2.利用登录用户来获取当前用户的角色和权限（可能需要查数据库）
        Set<String> roles = new HashSet<>();
        roles.add("user");
        if("hly".equals(user.getUsername())) {
            //hly用户有user和admin两个权限，其他用户登录只有user权限
            roles.add("admin");
        }
        //3. 创建SimpleAuthorizationInfo，并设置roles属性
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
        //4. 返回SimpleAuthorizationInfo对象
        return info;


    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行授权逻辑");

        // TODO Auto-generated method stub
        System.out.println("First Realm : "+ token.hashCode());
        //1. 将token转换成UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        //2. 从UsernamePasswordToken中获取username
        String username = upToken.getUsername();

        //3. 从数据库中获取username对应的记录
        System.out.println("从数据库中获取username："+username);
        //User user = User.queryUser(username);
        User user = userService.queryByUsername(username);

        //4. 若用户不存在，抛出UnknowAccountException
        if(user==null) {
            throw new UnknownAccountException("用户不存在");
        }

        //5. 根据用户信息是否抛出其他异常
        if(user.getValidFlag()==0) {
            throw new LockedAccountException("用户被锁定！");
        }


        //6. 根据用户情况，来构建AuthenticationInfo对象并返回,通常使用SimpleAuthenticationInfo返回
        //Principal:认证的实体信息
        //credentials：密码
        //hashedCredentials  当前Realm对象的name
        Object principals = user;
        String credentials = user.getPassword();
        String realmName = getName();
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUsername());
//		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principals, credentials, realmName);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principals, credentials, credentialsSalt, realmName);


        return info;

    }



    /*public static void main(String[] args) {
        String username = "error";

        String hashAlgorithmName = "MD5";	//加密算法
        Object credentials = "123456";		//密码

        Object salt = ByteSource.Util.bytes(username);					//盐值
        int hashInterations = 25;			//加密次数
        SimpleHash arge = new SimpleHash(hashAlgorithmName, credentials, salt, hashInterations);

        System.out.println(arge);
    }*/


}
