package com.service.impl;

import com.domain.Contact;
import com.mapper.ContactMapper;
import com.service.IContactService;
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
open class ContactServiceImpl : ServiceImpl<ContactMapper, Contact>(), IContactService {

}
