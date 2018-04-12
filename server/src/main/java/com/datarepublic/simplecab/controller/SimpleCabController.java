package com.datarepublic.simplecab.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.datarepublic.simplecab.exception.RestApiException;
import com.datarepublic.simplecab.exception.RestApiHttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datarepublic.simplecab.service.CacheService;
import com.datarepublic.simplecab.service.SimpleCabService;


@RestController
public class SimpleCabController {

	@Autowired
	private SimpleCabService simpleCabService;
	
	@Autowired
	private CacheService cacheService;

	
	@RequestMapping("/")
	public Map<String, Long> getCountByMedallionsAndPickupDatetime(@RequestParam List<String> medallions, 
																	  @RequestParam(value = "pickupDate") 
																	  @DateTimeFormat(pattern = "dd/MM/yyyy") Date pickupDate, 
																	  @RequestParam boolean ignoreCache) throws Exception {
		if(CollectionUtils.isEmpty(medallions)) {
			throw new RestApiException(RestApiHttpStatus.BAD_REQUEST).userMessage("Medallion names are required");
		}
		if(pickupDate == null) {
			throw new RestApiException(RestApiHttpStatus.BAD_REQUEST).userMessage("PickupDate is required");
		}
		
		return simpleCabService.getCountByMedallionsAndPickupDatetime(medallions, pickupDate, ignoreCache);
	}
	
	@RequestMapping("/resetCache")
	public String resetCache() {
		cacheService.resetAllEntries();
		return "Cache Reset";
	}
	
	
	
	
}
