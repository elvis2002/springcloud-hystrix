package com.goodrain.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.*;
import com.goodrain.service.RemoteShowService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;


@RestController
@RequestMapping("/second")
public class HystrixShowController {

	@Autowired
    private RemoteShowService remoteShowService;

    @RequestMapping("/hystrix")
    public String remoteShow() {
    	return remoteShowService.remoteShow();
    }
}
