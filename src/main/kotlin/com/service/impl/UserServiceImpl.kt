package com.service.impl;

import com.domain.User;
import com.mapper.UserMapper;
import com.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sam
 * @since 2021-04-15
 */
@Service
open class UserServiceImpl : ServiceImpl<UserMapper, User>(), IUserService {

}
