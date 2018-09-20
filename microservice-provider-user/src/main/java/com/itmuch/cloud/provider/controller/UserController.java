package com.itmuch.cloud.provider.controller;

import com.itmuch.cloud.provider.dao.UserRepository;
import com.itmuch.cloud.provider.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/20.
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 注：@GetMapping("/{id}")是spring 4.3的新注解等价于：
     *
     * @param id
     * @return user信息
     * @RequestMapping(value = "/id", method = RequestMethod.GET)
     * 类似的注解还有@PostMapping等等
     */
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    /**
     * 本地服务实例的信息
     *
     * @return
     */
    @GetMapping("/instance-info")
    public List<ServiceInstance> showInfo() {
        List<ServiceInstance> serviceInstances = new ArrayList<>();
        for (String s : discoveryClient.getServices()) {
            System.out.println("services " + s);
            serviceInstances = discoveryClient.getInstances(s);
            for (ServiceInstance si : serviceInstances) {
                System.out.println("    services:" + s + ":getHost()=" + si.getHost());
                System.out.println("    services:" + s + ":getPort()=" + si.getPort());
                System.out.println("    services:" + s + ":getServiceId()=" + si.getServiceId());
                System.out.println("    services:" + s + ":getUri()=" + si.getUri());
                System.out.println("    services:" + s + ":getMetadata()=" + si.getMetadata());
            }

        }
        return serviceInstances;
    }
}
