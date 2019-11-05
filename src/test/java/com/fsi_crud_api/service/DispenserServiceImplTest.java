/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.service;

import com.fsi_crud_api.model.Dispenser;
import com.fsi_crud_api.daorepsitory.DispenserRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Terseer
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class DispenserServiceImplTest {

    @Mock
    private DispenserRepository dispenserRepository;

    @InjectMocks
    private DispenserServiceImpl dispsenserService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllDispenser() {
        List<Dispenser> dispenserList = new ArrayList<>();
        dispenserList.add(new Dispenser(1L, "Todo Sample 1", "MDd", "GAS", "Manual", "Standard", "Local"));
        dispenserList.add(new Dispenser(2L, "Todo Sample 1", "MDd", "GAS", "Manual", "Standard", "Local"));
        dispenserList.add(new Dispenser(3L, "Todo Sample 1", "MDd", "GAS", "Manual", "Standard", "Local"));
        when(dispenserRepository.findAll()).thenReturn(dispenserList);

        List<Dispenser> result = dispsenserService.getAllDispensers();
        assertEquals(3, result.size());
    }

    @Test
    public void testGetSingleDispenser() {
        Dispenser dispenser = new Dispenser(1L, "MGP002", "MDd", "GAS", "Manual", "Standard", "Local");
        when(dispenserRepository.findOne(1L)).thenReturn(dispenser);
        Dispenser result = dispsenserService.getDispenserById(1);
        assertEquals("MGP002", result.getName());
    }

    @Test
    public void testSaveDispenser() {
        Dispenser dispenser = new Dispenser(4L, "MGP004", "MDd", "GAS", "Manual", "Standard", "Local");
        when(dispenserRepository.save(dispenser)).thenReturn(dispenser);
        Dispenser result = dispsenserService.addDispenser(dispenser);
        assertEquals("MGP004", result.getName());
    }

    @Test
    public void testUpdateDispenser() {
        Dispenser dispenser = new Dispenser(4L, "MGP004", "MDd", "GAS", "Manual", "Standard", "Local");
        when(dispenserRepository.save(dispenser)).thenReturn(dispenser);
        Dispenser result = dispsenserService.updateDispenser(dispenser);
        assertEquals("MGP004", result.getName());
    }

    @Test
    public void removeDispenser() {
        Dispenser dispenser = new Dispenser(4L, "MGP001", "MDd", "GAS", "Manual", "Standard", "Local");
        dispsenserService.deleteDispenser(dispenser);
        verify(dispenserRepository, times(1)).delete(dispenser);
    }
}
