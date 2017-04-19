package com.goodrain.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RemoteShowService {
	
	@Autowired
    private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "reliable", groupKey = "Demo", commandKey = "Show", commandProperties = { @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") })
	public String remoteShow() {
		return restTemplate.getForObject("http://DEMO-SERVICE/demo/show", String.class);
	}

	public String reliable() {
		return "fallback Method";
	}
}