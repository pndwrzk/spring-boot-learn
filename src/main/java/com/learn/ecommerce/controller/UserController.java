package com.learn.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.ecommerce.model.request.RegisterRequest;
import com.learn.ecommerce.model.response.BaseResponse;
import com.learn.ecommerce.service.UserService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public BaseResponse postRegister (
        @RequestBody RegisterRequest registerRequest
    ){
       Boolean result = userService.register(registerRequest);
    return new BaseResponse(result, "Success", result);
    }
    
}
