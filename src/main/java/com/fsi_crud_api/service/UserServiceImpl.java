/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.service;

import com.fsi_crud_api.daorepsitory.UserRepository;
import com.fsi_crud_api.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Terseer
 */
@Service("userService")
public class UserServiceImpl implements IUserService{
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Long userId) {
         return userRepository.findOne(userId); 
    }

    @Override
    public User addUser(User user) {
         return userRepository.save(user); 
    }

    @Override
    public User updateUser(User user, long id) {
        return userRepository.save(user); 
    }

    @Override
    public void deleteUser(User userId) {
        userRepository.delete(userId);
    }

    @Override
    public List<User> getAllUsers() {
       return userRepository.findAll();
    }
    
}
