package com.itmuch.cloud.feign.service;

import com.itmuch.cloud.feign.entity.User;
import com.itmuch.cloud.feign.service.impl.UserFeignClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 使用@FeignClient("microservice-provider-user")注解绑定
 * microservice-provider-user服务，还可以使用url参数指定一个URL。
 *
 * @author wangkun
 */
@FeignClient(name = "microservice-provider-user", fallback = UserFeignClientImpl.class)
public interface UserFeignClient {
    @RequestMapping("/{id}")
    User findByIdFeign(@RequestParam("id") Long id);
}
