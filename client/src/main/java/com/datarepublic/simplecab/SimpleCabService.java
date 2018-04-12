package com.datarepublic.simplecab;

import java.util.Map;

public interface SimpleCabService {

  void deleteCache();

  Map<String, Integer> getMedallionsSummary(String pickupDate, String... medallions);

  Map<String, Integer> getMedallionsSummary(String pickupDate, boolean ignoreCache, String... medallions);


}
