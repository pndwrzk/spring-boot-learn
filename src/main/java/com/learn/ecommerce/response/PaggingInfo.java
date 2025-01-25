package com.learn.ecommerce.response;

import java.util.List;

import lombok.Data;

@Data
public class PaggingInfo<T> {
   public Integer currentPage;
   public Integer nextPage;
    public Integer prevPage;
    public Integer totalPage;
    public List<T> contents;


}
