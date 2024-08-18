package cn.youyou.sc.common;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 单元化请求设计
 * @param <T>
 */
@Data
public class BaseRequest<T> {

    // 通用域
    private int appId;  // 应用ID
    private int targetAppId;
    private int serviceId; // 服务ID

    private String traceId;
    private String spanId;

    // 业务域
    private long customId; // 核心客户号

    // 扩展域
    private Map<String, Object> headers = new LinkedHashMap<>();
    private Map<String, Object> properties = new LinkedHashMap<>();

    // 私有域
    T data;

}
