package com.example.springsecurity.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    // 认证授权管理器
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("wyq").password("123").authorities("PRODUCT_ADD");
    }

    // 拦截资源配置
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // antMatchers 表示要拦截的资源
        // hasAuthority 表示有该权限才能访问(权限不足报403错误，错误页面可以定制)
        http.authorizeRequests()
                .antMatchers("/product/add").hasAuthority("PRODUCT_ADD")
                .antMatchers("/product/update").hasAuthority("PRODUCT_UPDATE")
                .antMatchers("/product/delete").hasAuthority("PRODUCT_DELETE")
                .antMatchers("/product/find").hasAuthority("PRODUCT_FIND")
                .antMatchers("/**")
                .fullyAuthenticated()
                .and()
                // .httpBasic() 弹窗登录
                .formLogin() // 表单登录
                .and()
                .csrf().disable();
                ;
    }
}
