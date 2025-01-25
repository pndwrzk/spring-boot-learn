package com.learn.ecommerce.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 @NoArgsConstructor
@AllArgsConstructor

@Data
public class BaseResponse {
    public Boolean status;
    public String message;  
    public Object data;

}
