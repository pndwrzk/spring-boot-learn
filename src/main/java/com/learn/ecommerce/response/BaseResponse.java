package com.learn.ecommerce.response;

import lombok.Data;

// @NoArgsConstructor
// @AllArgsConstructor
// @Getter
// @Setter
@Data
public class BaseResponse {
    public Boolean status;
    public String message;  
    public Object data;

}
