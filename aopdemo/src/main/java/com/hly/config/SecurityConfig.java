package com.hly.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;


//public class SecurityConfig{}
/**
 * @author linyuhuang
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {




   /**
     * 配置拦截器保护请求
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/*.html","/templates/**","/index","swagger-resources/**","/druid/**").permitAll()
                .antMatchers("/user/**").hasRole("USER")
//                .and().csrf().requireCsrfProtectionMatcher(new RequestMatcher() {
//                    @Override
//                    public boolean matches(HttpServletRequest httpServletRequest) {
//                        String servletPath = httpServletRequest.getServletPath();
//                        if (servletPath.contains("/druid")) {
//                            return false;
//                        }
//                        return true;
//                    }
//                })
                //Spring boot、Spring Security和Druid集成后，因csrf校验开启，不能登录http://localhost:8086/druid/login.html的解决办法,上面那种解决办法可以解决druid问题，但会导致其他的问题出现
//                .and().csrf().ignoringAntMatchers("/druid/*")
                .and().csrf().disable()

                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")
                                .permitAll()        //增加该行可以防止"spring boot security 将您重定向的次数过多" 问题
                                .failureUrl("/login-error")
                )
        ;



        super.configure(http);
    }

    /**
     * 配置user-detail服务
     * @throws Exception
     */
    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }

}
