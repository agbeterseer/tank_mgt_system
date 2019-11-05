/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.daorepsitory;

import com.fsi_crud_api.model.StationTransaction;
import io.lettuce.core.dynamic.annotation.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Terseer
 */
@Repository("stationTransactionRepository")
public interface StationTransactionRepository extends JpaRepository<StationTransaction, Long> {

    public StationTransaction findOne(Long transactionId);

    @Query(value = "SELECT s FROM StationTransaction s WHERE s.tank_id = :tank_id order by created_at desc", nativeQuery = true)
    public StationTransaction findTransactionByTankID(@Param("tank_id") long tank_id);

    @Query("SELECT s FROM StationTransaction s WHERE s.tank_id = :tank_id")
    public List<StationTransaction> findByID(@Param("tank_id") long tank_id);
 
}
