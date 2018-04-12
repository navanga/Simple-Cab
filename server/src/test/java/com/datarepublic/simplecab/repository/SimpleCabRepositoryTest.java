package com.datarepublic.simplecab.repository;

import com.datarepublic.simplecab.model.CabTripData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SimpleCabRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SimpleCabRepository simpleCabRepository;

    private CabTripData cabTripData;

    @Before
    public void setup() {
        cabTripData = new CabTripData();
        cabTripData.setMedallion("Medallion100");
        cabTripData.setPickupDateTime(Calendar.getInstance().getTime());

        entityManager.persist(cabTripData);
        entityManager.flush();
    }

    @Test
    public void testGetCountByMedallionAndPickupDatetime() {

        Assert.assertEquals(simpleCabRepository.getCountByMedallionAndPickupDatetime(cabTripData.getMedallion(),
                cabTripData.getPickupDateTime()), new Long(1));

    }

}
