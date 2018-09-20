package com.itmuch.cloud.feign.controller;

import com.itmuch.cloud.feign.entity.User;
import com.itmuch.cloud.feign.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/9/20.
 */
@RestController
public class FeignController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("feign/{id}")
    public User findByIdFeign(@PathVariable Long id) {
        User user = this.userFeignClient.findByIdFeign(id);
        return user;
    }
}
