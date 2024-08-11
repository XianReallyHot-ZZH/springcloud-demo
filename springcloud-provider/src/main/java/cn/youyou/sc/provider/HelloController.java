package cn.youyou.sc.provider;

import cn.youyou.sc.api.HelloService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements HelloService {
    @Override
    public String hello() {
        return "hello springcloud";
    }

    @Override
    public String a(String name) {
        return "hello a," + name;
    }

    @Override
    public String b(String name) {
        return "hello b," + name;
    }
}
