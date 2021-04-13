package com.domain

import com.baomidou.mybatisplus.annotation.TableName

@TableName("user")
data class User(var id: Long?=null, var username: String, var password: String);