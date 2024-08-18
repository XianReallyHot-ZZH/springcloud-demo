package cn.youyou.sc.provider.service.impl;

import cn.youyou.sc.api.model.User;
import cn.youyou.sc.provider.mapper.UserMapper;
import cn.youyou.sc.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> list(String name){
        return userMapper.list(name);
    }

    public User findById(long id) {
        return userMapper.findById(id);
    }

}
