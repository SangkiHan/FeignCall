package com.feigncall.service;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feigncall.client.FeignCall;

import feign.Response;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeignService {
	
	private final FeignCall feignCall;
	
	public void feignTest() throws IOException {
		Response feignResponse = feignCall.getTeam();
		
		String textBody = extractContent(feignResponse); 
		
		JsonNode resultNode = new ObjectMapper().readTree(textBody);
		
		return;
	}
	
	private String extractContent(Response response) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try{
            StreamUtils.copy(response.body().asInputStream(), output);
        } catch (FileNotFoundException ex) {
            return null;
        } catch (Exception ex) {
            return null;
        }
        return new String(output.toByteArray());
	}
}
