package cn.youyou.sc.consumer;

import cn.youyou.sc.api.model.User;
import cn.youyou.sc.consumer.contract.HelloApiServiceClient;
import cn.youyou.sc.consumer.contract.UserApiServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.ApplicationContext;
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
    UserApiServiceClient userService;

    @Autowired
    HelloApiServiceClient helloService;

    @Autowired
    ApplicationContext context;

    @Bean
    ApplicationRunner runner() {
        return args -> {
            System.out.println("helloService-consumer started");

            for (int i = 0; i < 10; i++) {
                test();
            }

            context.getBeansWithAnnotation(FeignClient.class).forEach((k, v) -> {
                System.out.println(" FeignClient ==> " + k + " : " + v);
            });

            System.out.println(Arrays.toString(context.getBeanNamesForType(HelloApiServiceClient.class)));
            System.out.println(Arrays.toString(context.getBeanNamesForType(UserApiServiceClient.class)));

            Arrays.stream(context.getBeanDefinitionNames())
                    .filter(x -> x.contains("hello")||x.contains("user")).forEach(System.out::println);

        };
    }

    private void test() {
        String hello = helloService.hi();
        System.out.println("==> helloService.hello : " + hello);
        hello = helloService.a("youyou");
        System.out.println("==> helloService.a : " + hello);
        hello = helloService.b("HaHa");
        System.out.println("==> helloService.b : " + hello);

        hello = helloService.c("jayjay");
        System.out.println("==> helloService.c : " + hello);


        User user123 = userService.findById(123);
        System.out.println("==> helloService.list : " + user123);
    }

}
