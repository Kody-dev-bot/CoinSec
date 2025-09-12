package com.coinsec.auth.service.impl;

import com.coinsec.auth.entity.User;
import com.coinsec.auth.mapper.UserMapper;
import com.coinsec.auth.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author kody
 * @since 2025-09-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
