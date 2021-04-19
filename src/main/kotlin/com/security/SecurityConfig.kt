package com.security

import com.security.core.UserAuthenticationProvider
import com.security.handler.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import kotlin.jvm.Throws


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig : WebSecurityConfigurerAdapter() {
    @Autowired
    lateinit var userLoginSuccessHandler: UserLoginSuccessHandler;

    @Autowired
    lateinit var userLoginFailureHandler: UserLoginFailureHandler
    /**
     * 自定义注销成功处理器
     */
    @Autowired
    lateinit var userLogoutSuccessHandler: UserLogoutSuccessHandler
    /**
     * 自定义暂无权限处理器
     */
    @Autowired
    lateinit var userAuthAccessDeniedHandler: UserAuthAccessDeniedHandler
    /**
     * 自定义未登录的处理器
     */
    @Autowired
    lateinit var userAuthenticationEntryPointHandler: UserAuthenticationEntryPointHandler
    /**
     * 自定义登录逻辑验证器
     */
    @Autowired
    lateinit var userAuthenticationProvider: UserAuthenticationProvider


    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder? {
        return BCryptPasswordEncoder()
    }


    @Throws(Exception::class)
    override fun configure(http: HttpSecurity?) {
        if (http != null) {
            http.authorizeRequests()
                    //不进行权限验证的请求或资源(从配置文件中读取)
                    //其他的需要登陆后才能访问
                    .anyRequest().authenticated()
                    .and()
                    //配置未登录自定义处理类
                    .httpBasic().authenticationEntryPoint(userAuthenticationEntryPointHandler)
                    .and()
                    //配置登录地址
                    .formLogin()
                    .loginProcessingUrl("/login/userLogin")
                    //配置登录成功自定义处理类
                    .successHandler(userLoginSuccessHandler)
                    //配置登录失败自定义处理类
                    .failureHandler(userLoginFailureHandler)
                    .and()
                    //配置登出地址
                    .logout()
                    .logoutUrl("/login/userLogout")
                    //配置用户登出自定义处理类
                    .logoutSuccessHandler(userLogoutSuccessHandler)
                    .and()
                    //配置没有权限自定义处理类
                    .exceptionHandling().accessDeniedHandler(userAuthAccessDeniedHandler)
                    .and()
                    // 开启跨域
                    .cors()
                    .and()
                    // 取消跨站请求伪造防护
                    .csrf().disable()
        };
        // 基于Token不需要session
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        // 禁用缓存
//        http.headers().cacheControl();
//        // 添加JWT过滤器
//        http.addFilter(new JWTAuthenticationTokenFilter(authenticationManager()));
//
//        http?.authorizeRequests()?.anyRequest()?.permitAll()?.and()?.logout()?.permitAll()
    }
//    override fun configure(http: HttpSecurity?) {
//        http.authorizeRequests().anyRequest().permitAll().and().logout().permitAll();
//    }

}