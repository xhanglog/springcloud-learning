package com.xhanglog.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author xhang
 * Date 2020/3/19
 **/
@Data
@AllArgsConstructor//全参数构造方法
@NoArgsConstructor//空参构造方法
public class CommonResult<T> {

    private Integer code;//返回状态码
    private String message;//消息串
    private T data;//返回数据


    //自定义一个构造方法，因为返回的数据可能有些data为空
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
