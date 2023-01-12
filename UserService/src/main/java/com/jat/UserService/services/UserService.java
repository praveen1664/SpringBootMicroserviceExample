package com.jat.UserService.services;

import com.jat.UserService.entities.User;

import java.util.List;

public interface UserService {
//    User ops
//    Create user
    User saveUser(User user);
//    get all users
    List<User> getallUsers();
//    get a siungle user
    User getUser(String userId);

}
