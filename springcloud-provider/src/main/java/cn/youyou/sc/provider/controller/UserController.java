package cn.youyou.sc.provider.controller;

import cn.youyou.sc.api.model.User;
import cn.youyou.sc.api.service.UserApiService;
import cn.youyou.sc.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApiService {

    @Value("${server.port}")
    private int port;

    @Autowired
    UserService userService;

    public List<User> list(String name){
        return userService.list(name + "-" + port);
    }

    public User findById(long id){
        User user = userService.findById(id);
        user.setName(user.getName() + "-" + port);
        return user;
    }
}
