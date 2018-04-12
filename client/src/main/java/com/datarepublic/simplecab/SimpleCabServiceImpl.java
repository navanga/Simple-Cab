package com.datarepublic.simplecab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("SimpleCabService")
public class SimpleCabServiceImpl implements SimpleCabService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${remote.host.url:http://localhost:8080/}")
    private String serverUrl;

    @Override
    public void deleteCache() {
        ResponseEntity<String> response = restTemplate.getForEntity(serverUrl + "/resetCache", String.class);
        System.out.println(response.getBody());

    }

    @Override
    public Map<String, Integer> getMedallionsSummary(String pickupDate, String... medallions) {
        return getMedallionsSummary(pickupDate, false, medallions);
    }

    @Override
    public Map<String, Integer> getMedallionsSummary(String pickupDate, boolean ignoreCache, String... medallions) {

        List<String> parameters = new ArrayList<>();

        Arrays.stream(medallions).forEach(med -> parameters.add("medallions=" + med));
        parameters.add("pickupDate=" + pickupDate);
        parameters.add("ignoreCache=" + ignoreCache);

        String params = parameters.stream().reduce((para, next) -> para + "&" + next).orElse("");

        ResponseEntity<HashMap> response = restTemplate.getForEntity(serverUrl + "?" + params, HashMap.class);

        System.out.println(response.getBody());

        return null;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
