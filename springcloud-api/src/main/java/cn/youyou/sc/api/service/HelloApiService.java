package cn.youyou.sc.api.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


public interface HelloApiService {

    @GetMapping("/api/hello/hi")
    String hi();

    @GetMapping("/api/hello/a")
    String a(@RequestParam("name") String name);

    @GetMapping("/api/hello/b")
    String b(@RequestParam("name") String name);

    @RequestMapping("/api/hello/c")
    String c(@RequestParam("name") String name);

}
