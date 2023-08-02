package com.feigncall;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.feigncall.service.FeignService;

@SpringBootTest
class FeignCallApplicationTests {
	
	@Autowired private FeignService feignService;

	@Test
	void contextLoads() throws IOException {
		feignService.feignTest();
	}

}
