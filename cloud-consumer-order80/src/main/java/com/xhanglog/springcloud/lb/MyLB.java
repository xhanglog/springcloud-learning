package com.xhanglog.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author xhang
 * Date 2020/3/23
 **/
@Component //让容器能够扫描到
public class MyLB implements LoadBalancer {
    //原子类，初始值0
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 获得第几次访问的数
     * @return
     */
    public final int getAndIncrement(){
        int current;
        int next;
        //自旋锁
        do {
            current = this.atomicInteger.get();
            // 获取下一个请求次数，整型最大为2147483647
            next = current >= 2147483647 ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        return next;
    }
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        //访问到次数与集群服务器数量取模，获得该由哪个服务器执行该请求
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
