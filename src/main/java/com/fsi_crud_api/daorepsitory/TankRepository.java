/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.daorepsitory;
 
import com.fsi_crud_api.model.Tank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Terseer
 */
@Repository("tankRepository")
public interface TankRepository extends JpaRepository<Tank, Long>{
    
    public Tank findOne(long tankId);
}
