package com.controller

import com.domain.User
import com.mapper.UserMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.web.bind.annotation.GetMapping

import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource


@RestController
class Controller {
    @Resource
    lateinit var userMapper: UserMapper
    @GetMapping("/")
    fun index(@RequestParam(value = "name", defaultValue = "World") name: String): List<User>{
        return userMapper.selectList(null)
    }
}