package cn.youyou.sc.consumer.contract;

import cn.youyou.sc.api.service.UserApiService;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(value = "providerService", contextId = "user")
public interface UserApiServiceClient extends UserApiService {

}
