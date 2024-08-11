package cn.youyou.sc.consumer;

import cn.youyou.sc.api.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "providerService", contextId = "hello")
public interface HelloServiceClient extends HelloService {
}
