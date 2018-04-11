package com.datarepublic.simplecab.repository;

import java.util.Date;

public interface SimpleCabRepository {

  Long getCountByMedallionAndPickupDatetime(String medallionId, Date pickupDate);
}
