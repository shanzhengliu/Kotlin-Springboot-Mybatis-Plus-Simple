package com.controller

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.domain.User
import com.service.UserService

import org.springframework.web.bind.annotation.GetMapping

import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource


@RestController
class Controller {

    @Resource
    lateinit var userService: UserService
    @GetMapping("/user/list")
    fun userlist(): List<User>{
        return userService.list();
    }

    @GetMapping("/user/byId")
    fun userById(@RequestParam(value = "Id", defaultValue = "0") Id: Int): User{
        return userService.getById(Id);
    }

    @GetMapping("/user/create")
    fun createUser(@RequestParam(value = "Name") Name: String,@RequestParam(value = "Password") Password: String): User{
        val user =  User(username = Name,password = Password)
        userService.save(user);
        return user
    }

    @GetMapping("/user/byName")
    fun userByName(@RequestParam(value = "Name") Name: String,
                   @RequestParam(value = "Page",defaultValue = "1") Page: Long,
                   @RequestParam(value = "PerPage",defaultValue = "10") PerPage: Long
    ): Page<User>{
        val queryWarpper : QueryWrapper<User> = QueryWrapper();
        queryWarpper.eq("username",Name)
        return userService.page(Page<User>(Page,PerPage), queryWarpper)

    }

}