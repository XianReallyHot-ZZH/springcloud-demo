package cn.youyou.sc.consumer;

import cn.youyou.sc.api.HelloService;
import cn.youyou.sc.api.UserService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SpringcloudConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsumerApplication.class, args);
    }

    @Autowired
    UserServiceClient userService;

    @Autowired
    HelloServiceClient helloService;

    @Bean
    ApplicationRunner runner() {
        return args -> {
            System.out.println("helloService-consumer started");

            String hello = helloService.hello();
            System.out.println("==> helloService.hello : " + hello);
            hello = helloService.a("youyou");
            System.out.println("==> helloService.a : " + hello);
            hello = helloService.b("YY");
            System.out.println("==> helloService.b : " + hello);


            String name = userService.list("kuangzhanshi");
            System.out.println("==> userService.list : " + name);

//            context.getBeansWithAnnotation(FeignClient.class).forEach((k, v) -> {
//                System.out.println(" FeignClient ==> " + k + " : " + v);
//            });
//
//            System.out.println(Arrays.toString(context.getBeanNamesForType(HelloServiceClient.class)));
//            System.out.println(Arrays.toString(context.getBeanNamesForType(UserServiceClient.class)));
//
//            Arrays.stream(context.getBeanDefinitionNames())
//                    .filter(x -> x.contains("hello")||x.contains("user")).forEach(System.out::println);

        };
    }

}
