/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.service;

import com.fsi_crud_api.collection.TankCollection;
import com.fsi_crud_api.model.Dispenser;
import com.fsi_crud_api.model.Tank;
import com.fsi_crud_api.daorepsitory.TankRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Terseer
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TankServiceTest {

    @Mock
    private TankRepository tankRepository;

    @InjectMocks
    private TankServiceImpl tankService;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetAllTanks() {
        List<Tank> tankList = new ArrayList<>();
        tankList.add(new Tank(1, "TANK001", "J007", "GAS", 45, new Dispenser(9L, "MGP001", "MDd", "GAS", "Manual", "Standard", "Local")));
        tankList.add(new Tank(2, "TANK001", "J007", "GAS", 45, new Dispenser(10L, "MGP002", "MDe", "FUEL", "Manual", "Standard", "Local")));
        tankList.add(new Tank(3, "TANK001", "J007", "GAS", 45, new Dispenser(11L, "MGP003", "MDf", "KERO", "Manual", "Standard", "Local")));
        when(tankRepository.findAll()).thenReturn(tankList);
        List<Tank> result = tankService.getAllTanks(); // typecast to TankCollection
        assertEquals(3, result.size());
    }

    @Test
    public void testGetSingleTank() {
        Dispenser dispenser = new Dispenser(9L, "MGP003", "MDf", "KERO", "Manual", "Standard", "Local");
        Tank tank = new Tank(1L, "TANK001", "J007", "GAS", 456, dispenser);
        when(tankRepository.findOne(1L)).thenReturn(tank);
        Tank result = tankService.getTankById(1L);
        assertEquals("TANK001", result.getName());

    }

    @Test
    public void testSaveTank() {
        Tank tank = new Tank(18, "TANK0018", "J007", "GAS", 145, new Dispenser(11L, "MGP003", "MDf", "KERO", "Manual", "Standard", "Local"));
        when(tankRepository.save(tank)).thenReturn(tank);
        Tank result = tankService.addTank(tank);
        assertEquals("TANK0018", result.getName());
    }

    @Test
    public void testUpdateTank() {
        Dispenser dispenser = new Dispenser(9L, "MGP003", "MDf", "KERO", "Manual", "Standard", "Local");
        Tank tank = new Tank(1L, "TANK001", "J007", "GAS", 456, dispenser);
        when(tankRepository.findOne(1L)).thenReturn(tank);
        Tank result = tankService.getTankById(1L);
        assertEquals("TANK001", result.getName());

    }

    @Test
    public void removeTank() {
        Tank tank = new Tank(17, "TANK0017", "J007", "GAS", 445, new Dispenser(11L, "MGP003", "MDf", "KERO", "Manual", "Standard", "Local"));
        tankService.deleteTank(tank);
        verify(tankRepository, times(1)).delete(tank);
    }

}
