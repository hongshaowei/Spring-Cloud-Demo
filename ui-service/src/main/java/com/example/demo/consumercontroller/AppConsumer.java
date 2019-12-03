package com.example.demo.consumercontroller;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("app-service")
public interface AppConsumer {

	@RequestMapping(method = RequestMethod.POST, value = "/apps/{id}", consumes = "application/json")
    Map<String, String> fetchAppsById(@PathVariable("id") String id);
}
