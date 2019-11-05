/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
   Dao interface that extends the JPA repository to automatically handle the crud queries.
 */
package com.fsi_crud_api.daorepsitory;

import com.fsi_crud_api.model.Dispenser; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Terseer
 */
@Repository("dispenserRepository")
public interface DispenserRepository extends JpaRepository<Dispenser, Long>{

    public Dispenser findOne(long dispenserId);
    
}
