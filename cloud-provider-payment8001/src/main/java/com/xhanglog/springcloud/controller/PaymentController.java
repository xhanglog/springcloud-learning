package com.xhanglog.springcloud.controller;

import com.xhanglog.springcloud.entity.CommonResult;
import com.xhanglog.springcloud.entity.Payment;
import com.xhanglog.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author xhang
 * Date 2020/3/19
 **/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int res = paymentService.create(payment);
        log.info("-----------------插入结果：" + res);
        if (res > 0){
            return new CommonResult(200,"插入成功,serverPort"+serverPort, res);
        }else {
            return new CommonResult(444,"插入失败,serverPort"+serverPort);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("-----------------查询结果：" + payment);
        if (payment != null){
            return new CommonResult(200,"查询成功,serverPort"+serverPort, payment);
        }else {
            return new CommonResult(444,"查询失败，serverPort"+serverPort+",id为："+id);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element: services){
            log.info("------------------------element："+element);
        }
        //根据服务别名获取实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance: instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    /**
     *  模拟一个处理时间长的业务请求
     * @return
     */
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try{
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return "paymentZipkin**************************";
    }
}
