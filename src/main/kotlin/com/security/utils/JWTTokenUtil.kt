package com.security.utils

import com.domain.User
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.util.*


object JWTTokenUtil {
    fun  createAccessToken(user: User): String { // 登陆成功生成JWT
        return Jwts.builder() // 放入用户名和用户ID
                .setId(user.id.toString()) // 主题
                .setSubject(user.username) // 签发时间
                .setIssuedAt(Date()) // 签发者
                .setIssuer("sans") // 自定义属性 放入用户拥有权限
                .claim("authorities", user.toString()) // 失效时间
                .setExpiration(Date(System.currentTimeMillis() + 1000*60)) // 签名算法和密钥
                .signWith(SignatureAlgorithm.HS512, "samliu")
                .compact()
    }
}