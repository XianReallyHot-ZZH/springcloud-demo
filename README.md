# springcloud-demo
[springcloud-demo](https://github.com/XianReallyHot-ZZH/springcloud-demo)是一个进行springcloud实践的demo仓库。

## 子模块说明
* [springcloud-api] 业务侧的API设计，通用业务接口、类定义
* [springcloud-provider] 业务服务提供端
* [springcloud-consumer] 业务服务消费端
* [springcloud-common] 技术侧的通用包，用于放置技术框架的基础的、通用的接口、类定义，比如放置单元化框架的基础、通用的接口、类定义

## 实践1：nacos + OpenFeign实现服务注册与RPC调用
### 环境准备
下载nacos（2.1.1），server端本地单机启动，启动指令参考：startup.sh -m standalone 或者 startup.cmd -m standalone

### 代码实践步骤
1. 服务端和消费端引入nacos服务注册与发现依赖
2. 抽象服务接口，服务接口方法需要注解@GetMapping、@PostMapping、@PutMapping、@DeleteMapping，明确表示服务的请求类型和路径
3. 服务端端实现服务接口，并注解@RestController，以web请求接口的方式开放服务
4. 服务注册AOP拦截，增加元数据提交（用于后面方便做服务的单元化）
5. 消费端自定义接口集成服务接口，并注解@FeignClient（注解上需要标注服务名+contextId），表明消费端以Feign的方式增强了服务接口远程调用的能力
6. 消费端使用被Feign代理的服务接口，实现RPC调用

### 总结
* Feign的服务桩子设计是以请求类型和路径作为服务接口方法的唯一标识，只存在于consumer端
* provider端无需引用Feign，只需实现服务接口，并注解@RestController，以接口请求+路径的方式暴露服务给Feign，因此provider端没有服务桩子的设计
* nacos只作为服务应用的注册与发现，其上没有任何关于服务方法的信息，作用只是在Feign远程调用的时候提供在线的应用实例信息，方便feign做负载均衡等

### 思考
Feign的服务桩子设计是以请求类型和路径作为服务接口方法的唯一标识，把服务的对外赋能强行绑定到接口层，而没有服务本身的service实现层的概念，意味着他把RPC远程调用的概念强行和接口路径做绑定了，这样的设计略显“僵硬”。服务对外赋能的形式不该、不能受限于某种具体的形式，强行绑定到web接口是不合理的。


## 实践2：SkyWalking分布式链路追踪-(初探)本地环境搭建
### 环境准备
1. 本地java环境：17
2. skywalking的server端：apache-skywalking-apm-10.0.1
3. skywalking的agent版本：apache-skywalking-java-agent-9.3.0

### 工程实践步骤
1. 根据情况修改skywalking的配置文件，全用默认配置即可，就不需额外的存储了，使用H2内存数据库，其他配置后续使用时可自行修改。
2. 启动skywalking的server和UI，指令参考：startup.sh 或者 startup.bat
3. 修改本项目springcloud-provider的idea启动配置，修改为：
   * VM options：-javaagent:D:\Developer\JavaSoftWare\APM\apache-skywalking-java-agent-9.3.0\skywalking-agent\skywalking-agent.jar
   * 环境参数：SW_AGENT_NAME=provider-application
4. 修改本项目springcloud-consumer的idea启动配置，修改为：
   * VM options：-javaagent:D:\Developer\JavaSoftWare\APM\apache-skywalking-java-agent-9.3.0\skywalking-agent\skywalking-agent.jar
   * 环境参数：SW_AGENT_NAME=consumer-application
5. 启动springcloud-provider和springcloud-consumer，访问http://localhost:8080/，查看skywalking的UI，点击仪表盘，点击General-Root，查看Service，Topology，Trace，Log监控页面。

### 源码学习资料
1. [SkyWalking 8.7.0 源码分析](https://skywalking.apache.org/zh/2022-03-25-skywalking-source-code-analyzation/)
2. [skywalking 9.4.0 agent+oap端源码阅读 + 二开实践](https://www.bilibili.com/video/BV1em421p7Jx/?spm_id_from=333.1007.top_right_bar_window_custom_collection.content.click&vd_source=bd1d4ea3f41e640817a8b79aa2cb267a)



## 实践3：SkyWalking分布式链路追踪-(进阶)
### 内容
比实践2更复杂的分布式链路追踪实践，涉及的中间件、框架：springcloudgateway,rocketmq,springcloud,feign,mysql,模拟出一个比较复杂的微服务调用链路，以验证skywalking的相关链路追踪功能：服务基本信息，服务拓扑，trace链路追踪，log，以及告警功能.

### 功能项目模块介绍
该项目的代码在skywalking-complete-demo模块中，该模块的子模块分别为：
1. （待补充）

### 功能验证步骤



