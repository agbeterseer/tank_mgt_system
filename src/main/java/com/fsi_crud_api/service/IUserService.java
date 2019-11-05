/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.service;

import com.fsi_crud_api.model.User;
import java.util.List;

/**
 *
 * @author Terseer
 */
public interface IUserService {

    User getUserById(Long userId);

    User addUser(User user);

    User updateUser(User user, long id);

    void deleteUser(User userId);

    List<User> getAllUsers();
}
