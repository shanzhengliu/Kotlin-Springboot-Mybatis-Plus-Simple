package com.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.domain.User
import org.apache.ibatis.annotations.Mapper


@Mapper
interface UserMapper : BaseMapper<User> {
}