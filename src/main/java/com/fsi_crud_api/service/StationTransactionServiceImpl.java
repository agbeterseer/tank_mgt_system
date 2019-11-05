/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.service;

import com.fsi_crud_api.daorepsitory.StationTransactionRepository;
import com.fsi_crud_api.daorepsitory.TankRepository;
import com.fsi_crud_api.exception.CurrentVolException;
import com.fsi_crud_api.exception.StationTransactionException;
import com.fsi_crud_api.model.StationTransaction;
import com.fsi_crud_api.model.Tank;
import com.fsi_crud_api.model.User;
import com.fsi_crud_api.request.StationTransactionRequest;
import com.fsi_crud_api.util.CONSTANTS;
import com.fsi_crud_api.util.ComputeVolumeLeftInTank;
import com.fsi_crud_api.util.CurrentVolumLleftValidator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Terseer
 */
@Service("stationTransactionService")
public class StationTransactionServiceImpl implements IStationTransactionService {

    @Autowired
    private StationTransactionRepository transactionRepository;

    @Autowired
    private TankRepository tankRepository;

    @Autowired
    private ITankService tankService;

    @Override
    public List<StationTransaction> getAllTransactions() {
        List<StationTransaction> stationTransactions = transactionRepository.findAll();
        if (stationTransactions.isEmpty()) {
            throw new StationTransactionException("Not Found");
        }
        return stationTransactions;
    }

    @Override
    public StationTransaction getTransactionById(Long transactionId) {
        StationTransaction stationTransaction = transactionRepository.findOne(transactionId);
        if (stationTransaction == null || stationTransaction.getId() <= 0) {
            throw new StationTransactionException("Not Found" + transactionId);
        }
        return stationTransaction;
    }

    @Override
    public StationTransaction addTransaction(StationTransaction transaction) {

        return transactionRepository.save(transaction);
    }

    @Override
    public StationTransaction updateTransaction(StationTransaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(StationTransaction tantransactionId) {
        transactionRepository.delete(tantransactionId);
    }

    @Override
    @SuppressWarnings("StringEquality")
    public StationTransaction tankDelivery(StationTransactionRequest transaction) {

        Tank payload_tank_id = transaction.getTankId();

        Tank currentVolInTank = tankRepository.findOne(payload_tank_id.getId()); // get the current vol let in tank

        double new_vol = currentVolInTank.getLiter() - transaction.getVolSoldByDispenser(); // get the available vol before refilling product in the Tank

        double newDelivery = transaction.getNewProduct() + currentVolInTank.getLiter();

        tankService.setNewVol(payload_tank_id.getId(), (int) newDelivery); // set new delivery into the Tank
 
        StationTransaction stationTransaction = new StationTransaction();
        stationTransaction.setUserId(transaction.getUserId());
        stationTransaction.setTankId(transaction.getTankId());
        stationTransaction.setTransactionType(transaction.getTransactionType());
        stationTransaction.setBeforeDelivery(new_vol);
        stationTransaction.setNewProduct(transaction.getNewProduct());
        transactionRepository.save(stationTransaction);

        return stationTransaction;
    }

    public StationTransaction getPreviousRecord(long tank_id) {
        StationTransaction stationTransaction = null;

        try {
            StationTransactionServiceImpl objIm = new StationTransactionServiceImpl();
            stationTransaction = objIm.getTransactionById(tank_id); 
            System.out.println("stationTransaction" + stationTransaction); 
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return stationTransaction;
    }

    public StationTransactionRequest saveVolOfProductSold(StationTransactionRequest stationTransaction) throws Exception {
          
        // get latest vol 
        Tank payload_tank_id = stationTransaction.getTankId();
        User payload_user_id = stationTransaction.getUserId();
  
        ComputeVolumeLeftInTank Objcom = new ComputeVolumeLeftInTank();
        double VolLeftInTank = Objcom.computeVolumeLeftInTank(payload_tank_id.getLiter(), stationTransaction.getVolSoldByDispenser());

        CurrentVolumLleftValidator objValidator = new CurrentVolumLleftValidator();

        if (objValidator.validateCurrentVolIsLessThanPreviousVol(stationTransaction.getVolSoldByDispenser(), stationTransaction.getVolLeftInTank())) {
            StationTransaction newOjb = new StationTransaction();
            newOjb.setTankId(payload_tank_id);
            newOjb.setUserId(payload_user_id);
            newOjb.setTransactionType(stationTransaction.getTransactionType());
            newOjb.setVolLeftInTank(VolLeftInTank);
            newOjb.setVolSoldByDispenser(stationTransaction.getVolSoldByDispenser());

            transactionRepository.save(newOjb);

        } else {
            throw new CurrentVolException("Current vol should not be more than previous vol");
        }

        return stationTransaction;
    }

    @SuppressWarnings("StringEquality")
    @Override
    public StationTransactionRequest addDailyTransaction(StationTransactionRequest transaction) throws Exception {

        if (null != transaction.getTransactionType()) {
            switch (transaction.getTransactionType()) {
                case CONSTANTS.ENDDAY: {
                    StationTransactionServiceImpl objIm = new StationTransactionServiceImpl();
                    objIm.saveVolOfProductSold(transaction);
                    break;
                }
                case CONSTANTS.DELIVERY: {
                    StationTransactionServiceImpl objIm = new StationTransactionServiceImpl();
                    objIm.tankDelivery(transaction);
                    break;
                }
                default:
                    break;
            }
        }
        return transaction;
    }
    
   

}
