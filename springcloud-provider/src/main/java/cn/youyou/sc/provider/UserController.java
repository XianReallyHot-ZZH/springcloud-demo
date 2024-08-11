package cn.youyou.sc.provider;

import cn.youyou.sc.api.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserService {

    @GetMapping("/api/user/list")
    @Override
    public String list(@RequestParam("name") String name) {
        return "list user: " + name;
    }

    @GetMapping("/api/user/find")
    @Override
    public String find(@RequestParam("name") String name) {
        return "find user: " + name;
    }
}
