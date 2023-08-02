package com.feigncall.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.feigncall.config.FeignConfig;

import feign.Response;

@FeignClient(name="test", url="${test.url}", configuration = FeignConfig.class)
public interface FeignCall {
	
	@GetMapping(value="/api/team/v1/findAll")
	public Response getTeam();

}
