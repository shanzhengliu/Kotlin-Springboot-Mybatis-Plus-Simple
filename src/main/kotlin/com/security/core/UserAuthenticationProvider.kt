package com.security.core
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.domain.User;
import com.service.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import kotlin.jvm.Throws

@Component
class UserAuthenticationProvider : AuthenticationProvider {
    @Autowired
    lateinit var userService : IUserService;
    @Throws
    override fun authenticate(authentication: Authentication?): Authentication {
        val userName = authentication?.principal as String;
        val password = authentication.credentials as String;
        val userInfo: User = userService.getOne(QueryWrapper<User>().eq("username",userName).last("limit 1"))
        return UsernamePasswordAuthenticationToken(userInfo, password, null);
    }

    override fun supports(authentication: Class<*>?): Boolean {
        return true
    }
}