package com.deer.service;

import com.deer.shiro.base.BaseServiceShiro;
import com.deer.mapper.shiro.UserMapper;
import com.deer.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseServiceShiro<User,UserMapper>{


}
