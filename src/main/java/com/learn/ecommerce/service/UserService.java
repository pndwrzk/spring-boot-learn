package com.learn.ecommerce.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learn.ecommerce.model.entity.UserEntity;
import com.learn.ecommerce.model.request.RegisterRequest;
import com.learn.ecommerce.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Boolean register(RegisterRequest registerRequest) {
        Optional<UserEntity> user = userRepository.findByPhoneNumber(registerRequest.getPhoneNumber());
        if (user.isPresent()) {
            return false;
        }
        try {
            UserEntity userEntity = new UserEntity();
            userEntity.setName(registerRequest.getName());
            userEntity.setPhoneNumber(registerRequest.getPhoneNumber());
            userEntity.setPassword(registerRequest.getPassword());
            userRepository.save(userEntity);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
