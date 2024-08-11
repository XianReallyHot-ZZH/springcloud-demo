package cn.youyou.sc.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


public interface HelloService {

    @GetMapping("/api/hello")
    String hello();

    @GetMapping("/api/a")
    String a(@RequestParam("name") String name);

    @GetMapping("/api/b")
    String b(@RequestParam("name") String name);

}
