package com.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.domain.User
import org.apache.ibatis.annotations.Mapper


@Mapper
interface UserMapper : BaseMapper<User> {
}