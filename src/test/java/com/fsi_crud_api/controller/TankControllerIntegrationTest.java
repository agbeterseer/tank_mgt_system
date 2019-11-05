/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.controller;

import com.fsi_crud_api.FsiCrudApiApplication; 
import com.fsi_crud_api.model.Tank;
 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.FixMethodOrder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;


/**
 *
 * @author Terseer
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FsiCrudApiApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TankControllerIntegrationTest {
    
     @Autowired
     private TestRestTemplate restTemplate;

     @LocalServerPort
     private int port;

     private String getRootUrl() {
         return "http://localhost:" + port;
     }

     @Test
     public void contextLoads() {

     }

     @Test
     public void testGetAllTanks() {
     HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/tanks",
        HttpMethod.GET, entity, String.class);  
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetTankById() {
        Tank tank = restTemplate.getForObject(getRootUrl() + "/tanks/1", Tank.class);
        System.out.println(tank.getName());
        assertNotNull(tank);
    }

    @Test
    public void testCreateTank() {
        Tank tank = new Tank();
        tank.setName("admin@gmail.com");
        tank.setTanktype("admin");
        tank.setStoredfuel("admin");
        ResponseEntity<Tank> postResponse = restTemplate.postForEntity(getRootUrl() + "/tanks", tank, Tank.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateTank() {
        int id = 1;
        Tank tank = restTemplate.getForObject(getRootUrl() + "/tanks/" + id, Tank.class);
        tank.setName("admin1");
        tank.setLiter(new Integer("432"));
        restTemplate.put(getRootUrl() + "/tanks/" + id, tank);
        Tank updatedTank = restTemplate.getForObject(getRootUrl() + "/tanks/" + id, Tank.class);
        assertNotNull(updatedTank);
    }

    @Test
    public void testDeleteTank() {
         int id = 2;
         Tank employee = restTemplate.getForObject(getRootUrl() + "/tanks/" + id, Tank.class);
         assertNotNull(employee);
         restTemplate.delete(getRootUrl() + "/employees/" + id);
         try {
              employee = restTemplate.getForObject(getRootUrl() + "/tanks/" + id, Tank.class);
         } catch (final HttpClientErrorException e) {
              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }
}
