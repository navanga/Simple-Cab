package com.datarepublic.simplecab.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.datarepublic.simplecab.repository.SimpleCabRepositoryJpaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.datarepublic.simplecab.repository.SimpleCabRepository;

@Service("simpleCabService")
public class SimpleCabServiceImpl implements SimpleCabService {

	@Autowired
	private SimpleCabRepository simpleCabRepository;
	
	@Autowired
	private CacheService cacheService;

	@Override
	public Map<String, Long> getCountByMedallionsAndPickupDatetime(List<String> medallions, Date pickupDate, boolean ignoreCache) {

		if (ignoreCache) {
			medallions.stream().forEach(medallionId -> cacheService.refreshCache(medallionId, pickupDate));
		}
		
		return medallions.stream()
				.collect(Collectors.toMap(medallion -> medallion,
				medallion -> simpleCabRepository.getCountByMedallionAndPickupDatetime(medallion, pickupDate)));

	}

}
