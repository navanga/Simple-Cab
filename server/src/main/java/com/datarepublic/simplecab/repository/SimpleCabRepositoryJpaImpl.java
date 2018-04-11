/**
 * 
 */
package com.datarepublic.simplecab.repository;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.datarepublic.simplecab.model.CabTripData;

@Repository("SimpleCabRepository")
public class SimpleCabRepositoryJpaImpl implements SimpleCabRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	@Transactional(readOnly=true)
	@Cacheable("medallionCounts")
	public Long getCountByMedallionAndPickupDatetime(String medallionId, Date pickupDate) {
		
		TypedQuery<Long> query =
				entityManager.createNamedQuery(CabTripData.FIND_TRIPS_BY_MEDALLION_AND_PICKUP_DATE, Long.class);
	        query.setParameter("medallion", medallionId);
	        query.setParameter("pickupDateStart", pickupDate);
	        query.setParameter("pickupDateEnd", getNextDate(pickupDate));

	        return query.getSingleResult();
		
	}
	
	//Move to Util class
	private Date getNextDate(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 1);
		return c.getTime();
	}
	
	// Don't do this at home
    private void simulateSlowService() {
        try {
        	System.out.println("in simulateSlowService()");
        	
            long time = 2000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }


}
