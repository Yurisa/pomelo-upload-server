package com.hdd.dubboprovider.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.hdd.dubboapi.service.HelloService;

@Service(version = "${demo.service.version}")
@Component
public class HelloServiceImpl implements HelloService {

    @Value("${server.port}")
    String port;

    @Value("${spring.application.name}")
    String appName;

    public String sayHello(String name) {
        return appName + ":" + port + "hello" + name;
    }
}