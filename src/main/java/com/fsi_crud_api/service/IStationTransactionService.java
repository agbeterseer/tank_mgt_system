/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.service;

import com.fsi_crud_api.model.StationTransaction;
import com.fsi_crud_api.request.StationTransactionRequest;
import java.util.List;

/**
 *
 * @author Terseer
 */
public interface IStationTransactionService {

    List<StationTransaction> getAllTransactions();

    StationTransaction getTransactionById(Long transactionId);

    StationTransaction addTransaction(StationTransaction transaction);

    StationTransaction updateTransaction(StationTransaction transaction);

    void deleteTransaction(StationTransaction tantransactionId);

    StationTransaction tankDelivery(StationTransactionRequest tantransactionId);

    StationTransactionRequest addDailyTransaction(StationTransactionRequest transaction) throws Exception;

}
