package com.tobeto.java4aPair4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tobeto.java4aPair4.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
