package cn.youyou.sc.provider;

import cn.youyou.sc.api.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserService {

    @Override
    public String list(String name) {
        return "list user: " + name;
    }

    @Override
    public String find(String name) {
        return "find user: " + name;
    }
}
