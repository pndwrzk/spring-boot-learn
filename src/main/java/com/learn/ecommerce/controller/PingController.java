package com.learn.ecommerce.controller;    
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.ecommerce.model.response.BaseResponse;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

@RestController
@RequestMapping("api/v1/ping")
@AllArgsConstructor
public class PingController {
  

    private final JdbcTemplate jdbcTemplate;
    @GetMapping
    BaseResponse ping() {
        BaseResponse response = new BaseResponse();
        try {
            jdbcTemplate.execute("SELECT * FROM product");
            response.setStatus(true);
            response.setMessage("Pong");
        } catch (Exception e) {
            response.setStatus(false);
            response.setMessage(e.getMessage());
        }
        return response;
        
    }
}
