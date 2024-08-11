package cn.youyou.sc.consumer;

import cn.youyou.sc.api.UserService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description for this class.
 *
 * @Author : kimmking(kimmking@apache.org)
 * @create 2024/8/10 下午8:35
 */

@FeignClient(value = "providerService", contextId = "user")
public interface UserServiceClient extends UserService {

}
