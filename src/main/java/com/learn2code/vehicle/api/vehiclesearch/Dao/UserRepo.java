package com.learn2code.vehicle.api.vehiclesearch.Dao;

import com.learn2code.vehicle.api.vehiclesearch.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer> {
    UserEntity findByUsername(String username);
}
