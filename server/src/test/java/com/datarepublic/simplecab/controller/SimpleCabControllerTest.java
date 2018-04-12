package com.datarepublic.simplecab.controller;

import com.datarepublic.simplecab.exception.RestApiException;
import com.datarepublic.simplecab.repository.SimpleCabRepository;
import com.datarepublic.simplecab.service.SimpleCabService;
import com.datarepublic.simplecab.service.SimpleCabServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.persistence.EntityManager;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(SimpleCabController.class)
public class SimpleCabControllerTest {

    @TestConfiguration
    static class SimpleCabControllerTestContextConfiguration {

        @Bean
        public SimpleCabService simpleCabService() {
            return Mockito.mock(SimpleCabServiceImpl.class);
        }
    }

    @Autowired
    private SimpleCabService simpleCabService;

    @MockBean
    private SimpleCabRepository simpleCabRepository;


    @Autowired
    private MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
       //simpleCabRepository = Mockito.mock(SimpleCabRepository.class);
    }

    @Test
    public void countValidateMandatoryParameters() throws Exception {

        ResultActions result = mockMvc.perform(get("/").contentType(MediaType.APPLICATION_JSON));

    }

    @Test(expected = RestApiException.class)
    public void testValidations() throws Exception {
        //mockMvc.addJob(null, 42L, new Object());
    }
}
