package com.xhanglog.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author xhang
 * Date 2020/3/23
 **/
public interface LoadBalancer {

    /**
     *  获取执行当前请求的服务器
     * @param serviceInstances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
