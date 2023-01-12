package com.jat.UserService.repositories;

import com.jat.UserService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String>
{
//    Add your custom methods if we want to add
}
