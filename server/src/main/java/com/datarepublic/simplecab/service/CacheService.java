package com.datarepublic.simplecab.service;

import java.util.Date;

public interface CacheService {

	void resetAllEntries();

	void refreshCache(String medallionId, Date pickupDate);

}
