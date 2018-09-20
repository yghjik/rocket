package com.itmuch.cloud.feign.service.impl;

import com.itmuch.cloud.feign.entity.User;
import com.itmuch.cloud.feign.service.UserFeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2018/9/20.
 */
@Component
public class UserFeignClientImpl implements UserFeignClient {
    @Override
    public User findByIdFeign(@RequestParam("id") Long id) {
        return null;
    }
}
