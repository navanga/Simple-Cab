package com.datarepublic.simplecab.service;

import com.datarepublic.simplecab.model.CabTripData;
import com.datarepublic.simplecab.repository.SimpleCabRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
public class SimpleCabServiceTest {

    @TestConfiguration
    static class SimpleCabServiceTestContextConfiguration {

        @Bean
        public SimpleCabService simpleCabService() {
            return new SimpleCabServiceImpl();
        }
    }

    @Autowired
    private SimpleCabService simpleCabService;

    @MockBean
    private SimpleCabRepository simpleCabRepository;

    @MockBean
    private CacheService cacheService;

    private List<String> medallions = new ArrayList<>();

    @Before
    public void setUp() {
        CabTripData cabTripData1 = new CabTripData();
        cabTripData1.setMedallion("Medallion100");
        cabTripData1.setPickupDateTime(getDateByString("20/10/2017"));

        medallions.add(cabTripData1.getMedallion());

        Mockito.when(simpleCabRepository.getCountByMedallionAndPickupDatetime(cabTripData1.getMedallion(),
                cabTripData1.getPickupDateTime())).thenReturn(1l);
    }

    @Test
    public void TestGetCountByMedallionsAndPickupDatetime() {
        Map<String, Long> resultMap = simpleCabService.getCountByMedallionsAndPickupDatetime(medallions,
                getDateByString("20/10/2017"), false);

        Assert.assertNotNull(resultMap);
        Assert.assertEquals(resultMap.size(), 1);
    }

    private Date getDateByString(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date pickupDate = null;
        try {
            pickupDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return pickupDate;
    }
}