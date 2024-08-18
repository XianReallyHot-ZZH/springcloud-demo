package cn.youyou.sc.consumer.contract;

import cn.youyou.sc.api.service.HelloApiService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "providerService", contextId = "hello")
public interface HelloApiServiceClient extends HelloApiService {
}
