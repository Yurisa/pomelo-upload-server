package com.hdd.dubboconsumer.controller;


import com.hdd.dubboapi.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Reference(version = "${demo.service.version}",loadbalance = "roundrobin")
    private HelloService helloService;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable(name = "name") String name) {
        return helloService.sayHello(name);
    }
}
