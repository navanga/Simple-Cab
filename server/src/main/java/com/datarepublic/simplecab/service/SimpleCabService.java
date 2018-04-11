package com.datarepublic.simplecab.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SimpleCabService {

	Map<String, Long> getCountByMedallionsAndPickupDatetime(List<String> medallion, Date pickupDate, boolean ignoreCache);

}
