package cn.youyou.sc.provider.mapper;

import cn.youyou.sc.api.model.User;

import java.util.List;

public interface UserMapper {

    List<User> list(String name);
    User findById(long id);

}
