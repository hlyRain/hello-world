package com.hly.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.*;


@Configuration
public class ShiroConfig {

    /**
     *  Shiro Spring-specific integration
     *  Post processor that automatically invokes init() and destroy() methods
     *          for Spring-configured Shiro objects so you don't have to
     *          1) specify an init-method and destroy-method attributes for every bean
     *             definition and
     *          2) even know which Shiro objects require these methods to be
     *             called.
     * @return
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    /**
     * Enable Shiro Annotations for Spring-configured beans.  Only run after
     *          the lifecycleBeanProcessor has run:
     * @return
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAAPC = new DefaultAdvisorAutoProxyCreator();
        defaultAAPC.setProxyTargetClass(true);
        return defaultAAPC;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier(value = "securityManager") SecurityManager manager){
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }



    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier(value = "securityManager") SecurityManager manager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //shiro内置过滤器
        /**
         * 常用过滤器
         *   anon: 无需认证可以访问
         *   authc: 必须认证才可以访问
         *   user：如果使用rememberMe的功能可以直接访问
         *   perms：该资源必须得到资源权限才可以访问
         *   role：该资源必须得到角色权限才可以访问
         */
        shiroFilterFactoryBean.setLoginUrl("/tologin");
        shiroFilterFactoryBean.setSuccessUrl("/index.html");
        shiroFilterFactoryBean.setUnauthorizedUrl("unauthorized.html");

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        // 静态资源放行
        filterChainDefinitionMap.put("*.js", "anon");
        filterChainDefinitionMap.put("*.css", "anon");
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/easyui/**", "anon");
        filterChainDefinitionMap.put("/images/**", "anon");

        //登录页面放行
        filterChainDefinitionMap.put("/","anon");
        filterChainDefinitionMap.put("/tologin","anon");
        filterChainDefinitionMap.put("/login","anon");

        //swagger 放行，druid放行
        filterChainDefinitionMap.put("/swagger-ui/**","anon");
        filterChainDefinitionMap.put("/druid/**","anon");
//        filterChainDefinitionMap.put("/tologin","anon");



//        filterChainDefinitionMap.put("/","anon");



        //登出页面
        filterChainDefinitionMap.put("/shiro/logout","logout");
        //其他页面需要认证
        filterChainDefinitionMap.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);


        //设置安全管理器

        shiroFilterFactoryBean.setSecurityManager(manager);
        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = {"securityManager"})
    public SecurityManager getDefaultWebSecurityManager(@Qualifier(value = "md5Realm") UserRealm md5Realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        //关联多路realm
//        List<Realm> realms = new ArrayList<>();
//        realms.add(md5Realm);
//        realms.add(sha1Realm);
        securityManager.setRealm(md5Realm);

        //设置验证策略
        /*ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();
        //只要验证一个正确了就通过
        authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        securityManager.setAuthenticator(authenticator);
*/

        return securityManager;
    }

    /**
     * 创建Realm
     * 该realm采用MD5算法加密，加密次数25次
     */
    @Bean(name = {"md5Realm"})
    public UserRealm getMD5Realm(){
        UserRealm realm = new UserRealm();

        //设置加密算法和加密次数
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("MD5");
        matcher.setHashIterations(25);

        realm.setCredentialsMatcher(matcher);
        return realm;
    }


    /**
     * 创建Realm
     * 该realm采用MD5算法加密，加密次数25次
     */
    /*@Bean(name = {"sha1Realm"})
    public UserRealm getSHA1Realm(){
        UserRealm realm = new UserRealm();

        //设置加密算法和加密次数
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("SHA1");
        matcher.setHashIterations(25);

        realm.setCredentialsMatcher(matcher);
        return realm;
    }*/


}
