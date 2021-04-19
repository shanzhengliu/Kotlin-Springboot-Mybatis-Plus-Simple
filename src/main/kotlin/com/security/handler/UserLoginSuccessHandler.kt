package com.security.handler

import com.domain.User
import com.security.utils.JSONResponse
import com.security.utils.JWTTokenUtil
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Component
class UserLoginSuccessHandler:AuthenticationSuccessHandler {
    override fun onAuthenticationSuccess(request: HttpServletRequest?, response: HttpServletResponse?, authentication: Authentication?) {
       val userinfo:User =  authentication?.getPrincipal() as User;
        val token: String = JWTTokenUtil.createAccessToken(userinfo)
        val resultData: HashMap<String, Any> = HashMap()
        resultData.put("token",token);
        JSONResponse.responseJson(200,response,resultData);



    }
}