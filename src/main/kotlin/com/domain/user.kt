package com.domain

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler

@TableName("user")
data class User(@TableId(type = IdType.AUTO) var id: Long?=null, var username: String?=null, var password: String?=null);