package com.learn2code.vehicle.api.vehiclesearch.config;

import com.learn2code.vehicle.api.vehiclesearch.Dao.UserRepo;
import com.learn2code.vehicle.api.vehiclesearch.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = new UserEntity();
        userEntity=userRepo.findByUsername(username);
        if (userEntity==null) throw new UsernameNotFoundException("user does not exist");
        UserDetails userDetails = new MyUserDetails(userEntity);
        return userDetails;
    }
}
