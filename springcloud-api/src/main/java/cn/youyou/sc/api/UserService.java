package cn.youyou.sc.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserService {

    @GetMapping("/api/user/list")
    String list(@RequestParam("name") String name);

    @GetMapping("/api/user/find")
    String find(@RequestParam("name") String name);

//    String list(String name);
//
//    String find(String name);

}
