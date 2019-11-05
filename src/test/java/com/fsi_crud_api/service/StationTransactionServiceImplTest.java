/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.service;

import com.fsi_crud_api.daorepsitory.StationTransactionRepository;
import com.fsi_crud_api.model.Dispenser;
import com.fsi_crud_api.model.StationTransaction;
import com.fsi_crud_api.model.Tank;
import com.fsi_crud_api.model.User;
import com.fsi_crud_api.request.StationTransactionRequest;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Terseer
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class StationTransactionServiceImplTest {

    @Mock
    StationTransactionRepository stationTransactionRepository;

    @InjectMocks
    StationTransactionServiceImpl stationTransactionService;

    LocalDateTime now = LocalDateTime.now();
    Timestamp timestamp1 = Timestamp.valueOf(now);

    public StationTransactionServiceImplTest() {
    }

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

    /**
     * Test of getAllTanks method, of class StationTransactionServiceImpl.
     */
    @Test
    public void testGetAllTransactions() {
        System.out.println("------AllTransactions--------");

        List<StationTransaction> expResult = new ArrayList<>();
        User user = new User(1L, "Terseer", "agbe.terseer@gmail.com", "password");
        Tank tank = new Tank(1, "TANK001", "J007", "GAS", 45, new Dispenser(9L, "MGP001", "MDd", "GAS", "Manual", "Standard", "Local"));
        expResult.add(new StationTransaction(1L, user, tank, 61.9, 2323.8, "End Day", timestamp1, timestamp1));
        when(stationTransactionRepository.findAll()).thenReturn(expResult);
        List<StationTransaction> result = stationTransactionService.getAllTransactions();
        System.out.println("------Result--------" + expResult.toString() + " time" + timestamp1);
        assertEquals(1, result.size());
    }

    /**
     * Test of getTransactionById method, of class
     * StationTransactionServiceImpl.
     */
    @Test
    public void testGetTransactionById() {
        System.out.println("----------getTransactionById----------");

        User user = new User(1L, "Terseer", "agbe.terseer@gmail.com", "password");
        Dispenser dispenser = new Dispenser(9L, "MGP001", "MDd", "GAS", "Manual", "Standard", "Local");
        Tank tank = new Tank(1, "TANK001", "J007", "GAS", 45, dispenser);
        StationTransaction stationTransaction = new StationTransaction(1L, user, tank, 61.9, 2323.8, "End Day", timestamp1, timestamp1);
        when(stationTransactionRepository.findOne(1L)).thenReturn(stationTransaction);
        StationTransaction result = stationTransactionService.getTransactionById(1L);

        assertEquals("End Day", result.getTransactionType());

    }

    /**
     * Test of addTransaction method, of class StationTransactionServiceImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testaddDailyTransaction() throws Exception {
        System.out.println("----------addDailyTransaction----------");

        User user = new User(1L, "Terseer", "agbe.terseer@gmail.com", "password");
        Dispenser dispenser = new Dispenser(9L, "MGP001", "MDd", "GAS", "Manual", "Standard", "Local");
        Tank tank = new Tank(1, "TANK001", "J007", "GAS", 45, dispenser);
        StationTransaction stationTransaction = new StationTransaction(1L, user, tank, 61.9, 2323.8, "End Day", timestamp1, timestamp1);
        when(stationTransactionRepository.findOne(1L)).thenReturn(stationTransaction);
        StationTransaction result = stationTransactionService.getTransactionById(1L);
        
        //StationTransaction result = stationTransactionService.addDailyTransaction(stationTransaction);
        assertEquals("End Day", result.getTransactionType());

    }

    @Test
    public void testaddDailyTransactionDelivery() throws Exception {
        System.out.println("----------addDailyTransaction----------");

        User user = new User(1L, "Terseer", "agbe.terseer@gmail.com", "password");
        Dispenser dispenser = new Dispenser(9L, "MGP001", "MDd", "GAS", "Manual", "Standard", "Local");
        Tank tank = new Tank(1, "TANK001", "J007", "GAS", 45, dispenser);
        StationTransaction stationTransaction = new StationTransaction(1L, user, tank, 61.9, 2323.8, "Delivery", 61.9, 954.9, timestamp1, timestamp1);
        StationTransactionRequest stationTransactionRequest = new StationTransactionRequest();
        stationTransactionRequest.setBeforeDelivery(stationTransaction.getBeforeDelivery());
        stationTransactionRequest.setId(stationTransaction.getId());
        stationTransactionRequest.setTankId(tank);
        stationTransactionRequest.setUserId(user);
        stationTransactionRequest.setVolLeftInTank(stationTransaction.getVolLeftInTank());
        stationTransactionRequest.setVolSoldByDispenser(stationTransaction.getVolSoldByDispenser());
        
        
        StationTransactionRequest result = stationTransactionService.addDailyTransaction(stationTransactionRequest);
        assertEquals("Delivery", stationTransactionRequest.getTransactionType());

    }
    /**
     * Test of updateTransaction method, of class StationTransactionServiceImpl.
     */
//    @Test
//    public void testUpdateTransaction() {
//        System.out.println("updateTransaction");
//        StationTransaction transaction = null; // new StationTransaction()
////        long transactionId = 0L;
//        StationTransactionServiceImpl instance = new StationTransactionServiceImpl();
//        StationTransaction expResult = null;
//        StationTransaction result = instance.updateTransaction(transaction);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of deleteTransaction method, of class StationTransactionServiceImpl.
     */
//    @Test
//    public void testDeleteTransaction() {
//        System.out.println("deleteTransaction");
//        StationTransaction tantransactionId = null;
//        StationTransactionServiceImpl instance = new StationTransactionServiceImpl();
//        instance.deleteTransaction(tantransactionId);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
