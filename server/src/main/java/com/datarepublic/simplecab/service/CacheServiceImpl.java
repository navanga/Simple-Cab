package com.datarepublic.simplecab.service;

import java.util.Date;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service("CacheService")
public class CacheServiceImpl implements CacheService {

	@Override
	@CacheEvict(value = "medallionCounts", allEntries = true)
	public void resetAllEntries() {
	    // Intentionally blank
	}
	
	@Override
	@CacheEvict(value = "medallionCounts")
	public void refreshCache(String medallionId, Date pickupDate) {
	    //This method will remove only this specific medallionId and pickup date
	}  

	
}
