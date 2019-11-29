package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

	@PostMapping("/apps/{id}")
	public Map<String, String> fetchAppsById(@PathVariable String id) {
		Map<String, String> apps = new HashMap<>();
		apps.put("原始碼比對作業", "111");
		apps.put("信用卡系統參數中心[EsunParam]", "222");
		apps.put("資料庫查詢申請作業[DBQuery]", "333");
		apps.put("資料庫異動申請作業[DBApply]", "444");
		apps.put("Log查詢系統[Query]", "555");
		return apps;
	}
}
