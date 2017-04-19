package com.goodrain.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Component;

@FeignClient("demo-service")
public interface RemoteInvokerService {
	
	@RequestMapping(value = "/demo/show", method = RequestMethod.GET)
	public String remoteInvoker();
}