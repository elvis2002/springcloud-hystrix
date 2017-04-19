package com.goodrain.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.*;
import com.goodrain.service.RemoteInvokerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;


@RestController
@RequestMapping("/first")
public class HystrixHelloController {

	@Autowired
    private RemoteInvokerService remoteInvokerService;

    @RequestMapping("hystrix")
    @HystrixCommand(fallbackMethod = "failme", groupKey = "Demo", commandKey = "first", commandProperties = { @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000") })
    public String remoteHello() {
    	return remoteInvokerService.remoteInvoker();
    }
    
    protected String failme() {
		return "failed invoked Method";
	}
}
