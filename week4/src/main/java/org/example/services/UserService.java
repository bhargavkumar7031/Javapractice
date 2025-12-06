package org.example.services;

import org.example.classes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.example.repository.UserRespository;

@Service
public class UserService {
    @Autowired
    private UserRespository userRepository;


    @Cacheable(value = "users")
    public Page<User> getUsers() {
        Pageable pageable = PageRequest.of(0, 20);
        return userRepository.findAll(pageable);
    }


}
