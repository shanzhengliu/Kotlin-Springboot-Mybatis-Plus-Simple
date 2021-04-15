package com.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.domain.User
import com.service.IUserService
import com.service.impl.UserServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sam
 * @since 2021-04-15
 */
@RestController
@RequestMapping("//user")
class UserController
{
    @Autowired
   lateinit var userService : IUserService

    @RequestMapping("/list")
    fun list(): Page<User>
    {
        return userService.page(Page<User>(2,3),null);
    }
}
