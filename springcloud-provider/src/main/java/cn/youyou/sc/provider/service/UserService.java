package cn.youyou.sc.provider.service;

import cn.youyou.sc.api.model.User;

import java.util.List;

public interface UserService {
    List<User> list(String name);
    User findById(long id);
}
